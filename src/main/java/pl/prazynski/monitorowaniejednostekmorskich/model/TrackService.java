package pl.prazynski.monitorowaniejednostekmorskich.model;

import com.fasterxml.jackson.databind.JsonNode;

import org.w3c.dom.Document;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import pl.prazynski.monitorowaniejednostekmorskich.dao.PortRepo;
import pl.prazynski.monitorowaniejednostekmorskich.dao.entity.Port;
import pl.prazynski.monitorowaniejednostekmorskich.manager.PortManager;
import pl.prazynski.monitorowaniejednostekmorskich.utils.Codes;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TrackService {
    RestTemplate restTemplate = new RestTemplate();


    /**
     * Zwraca liste portow
     * @return
     */
    public List<Point> getPorts(){


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity= new HttpEntity(httpHeaders);

        ResponseEntity<Port[]> exchange = restTemplate.exchange("http://localhost:8080/api/ports/all", HttpMethod.GET, httpEntity, Port[].class);

        List<Point> collect = Stream.of(exchange.getBody()).map(
                port -> new Point(
                        port.getX(),
                        port.getY(),
                        port.getName()
                )
        ).collect(Collectors.toList());
        return collect;
    }

    public Object getPortDetails(String portName){

        RestTemplate restTemplate = new RestTemplate();


        switch (portName){
            case "Swinoujscie":
                return restTemplate.getForObject("http://localhost:8080/api/ports/get/4", Port.class);
            case "Gdansk Port Polnocny":
                return restTemplate.getForObject("http://localhost:8080/api/ports/get/2", Port.class);
            case "Police":
                return restTemplate.getForObject("http://localhost:8080/api/ports/get/5", Port.class);
            case "Gdynia":
                return restTemplate.getForObject("http://localhost:8080/api/ports/get/1", Port.class);
            case "Szczecin":
                return restTemplate.getForObject("http://localhost:8080/api/ports/get/6", Port.class);
            case "Gdansk Nowy Port":
                return restTemplate.getForObject("http://localhost:8080/api/ports/get/3", Port.class);
            default: {
                System.out.println("Port jeszcze nieobslugiwany");
            }
        }

     return false;

    }


    /**
     * Zwraca liste statkow
     * @return
     */
    public List<ShipPoint> getShips(String portName){

        String apiURL = "";
        Double x = 54.536000;
        Double y = 18.558020;
        String camURL = "";

        switch (portName){
            case "Swinoujscie":
                apiURL = "https://www.umgdy.gov.pl/ksbm/PLSWI_in.xml";
                x = 53.938004;
                y = 14.271768;
                camURL = "http://88.218.254.213:8092/player.html";
                break;
            case "Gdansk Port Polnocny":
                apiURL = "https://www.umgdy.gov.pl/ksbm/PLGDN_in.xml";
                x = 54.397552;
                y = 18.718310;
                break;
            case "Police":
                apiURL = "https://www.umgdy.gov.pl/ksbm/PLPLC_in.xml";
                x = 53.556978;
                y = 14.599954;
                break;
            case "Gdynia":
                apiURL = "https://www.umgdy.gov.pl/ksbm/PLGDY_in.xml";
                x = 54.536000;
                y = 18.558020;
                break;
            case "Szczecin":
                apiURL = "https://www.umgdy.gov.pl/ksbm/PLSZZ_in.xml";
                x = 53.452866;
                y = 14.670593;
                break;
            case "Gdansk Nowy Port":
                apiURL = "https://www.umgdy.gov.pl/ksbm/PLNOW_in.xml";
                x = 54.413685;
                y = 18.650868;
                break;
            default: {
                System.out.println("Port jeszcze nieobslugiwany");
            }
        }

        List<Ship> shipList = parseShipsXML(apiURL);
        List <ShipPoint> shipPointsList = new ArrayList<>();

        for (int i = 0; i < shipList.size(); i++) {
            shipPointsList.add(
                    new ShipPoint(
                            this.getLocationX(x, y, 1000),
                            this.getLocationY(x, y, 1000),
                            shipList.get(i).getPortOfCall(),
                            shipList.get(i).getVesselName(),
                            shipList.get(i).getVesselFlag(),
                            shipList.get(i).getVesselType(),
                            shipList.get(i).getLastPort(),
                            shipList.get(i).getNextPort(),
                            shipList.get(i).getEta(),
                            shipList.get(i).getAta(),
                            shipList.get(i).getEtd(),
                            shipList.get(i).getCallId(),
                            shipList.get(i).getStatusId(),
                            shipList.get(i).getCountryCode()
                    )
            );

        }

        return shipPointsList;

    }

    /**
     * Generator wspolrzednej X
     * @param x0
     * @param y0
     * @param radius
     * @return
     */
    public double getLocationX(double x0, double y0, int radius) {
        Random random = new Random();

        // Convert radius from meters to degrees
        double radiusInDegrees = radius / 111000f;

        double u = random.nextDouble();
        double v = random.nextDouble();
        double w = radiusInDegrees * Math.sqrt(u);
        double t = 2 * Math.PI * v;
        double x = w * Math.cos(t);
        double y = w * Math.sin(t);

        // Adjust the x-coordinate for the shrinking of the east-west distances
        double new_x = x / Math.cos(Math.toRadians(y0));

        double foundLongitude = new_x + x0;
        double foundLatitude = y + y0;
        return foundLongitude;
    }

    /**
     * Generator wspolrzednej Y
     * @param x0
     * @param y0
     * @param radius
     * @return
     */
    public double getLocationY(double x0, double y0, int radius) {
        Random random = new Random();

        // Convert radius from meters to degrees
        double radiusInDegrees = radius / 111000f;

        double u = random.nextDouble();
        double v = random.nextDouble();
        double w = radiusInDegrees * Math.sqrt(u);
        double t = 2 * Math.PI * v;
        double x = w * Math.cos(t);
        double y = w * Math.sin(t);

        // Adjust the x-coordinate for the shrinking of the east-west distances
        double new_x = x / Math.cos(Math.toRadians(y0));

        double foundLongitude = new_x + x0;
        double foundLatitude = y + y0;
        return foundLatitude;
    }


    /**
     * Pobieranie danych z API dla portu Gdynia
     * @return
     */
    public String getShipsFromApi(String apiURL){

        RestTemplate rest = new RestTemplate();
        restTemplate.getMessageConverters()
                .add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));

        ResponseEntity<String> exchange = rest.exchange(apiURL,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String.class);
        return exchange.getBody();
    }

    /**
     * Zwraca kod podanego kraju
     * @param countryName
     * @return
     */
    public String getCountryCode(String countryName){
        Codes codes = new Codes();
        return codes.getCountryCode(countryName);
    }
    /**
     * Parsowanie XML-a ze statkami
     * @return
     */
    public List<Ship> parseShipsXML(String apiURL){
        List<Ship> ships = new ArrayList<Ship>();
        Ship ship = null;

        String rawXML = this.getShipsFromApi(apiURL).substring(3);
        byte[] bytes = rawXML.getBytes(StandardCharsets.UTF_8);
        String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);

        InputSource inputXml = new InputSource(new ByteArrayInputStream(utf8EncodedString.getBytes(StandardCharsets.UTF_8)));
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputXml);
            document.getDocumentElement().normalize();
            NodeList nList = document.getElementsByTagName("Visit");

            for(int temp = 0; temp < nList.getLength(); temp++){
                Node node = nList.item(temp);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element eElement = (Element) node;
                    ship = new Ship();
                    ship.setPortOfCall(eElement.getElementsByTagName("PortOfCall").item(0).getTextContent());
                    ship.setVesselName(eElement.getElementsByTagName("VesselName").item(0).getTextContent());
                    ship.setVesselType(eElement.getElementsByTagName("VesselType").item(0).getTextContent());
                    ship.setVesselFlag(eElement.getElementsByTagName("VesselFlag").item(0).getTextContent());
                    ship.setLastPort(eElement.getElementsByTagName("LastPort").item(0).getTextContent());
                    ship.setNextPort(eElement.getElementsByTagName("NextPort").item(0).getTextContent());
                    ship.setEta(eElement.getElementsByTagName("ETA").item(0).getTextContent());
                    ship.setAta(eElement.getElementsByTagName("ATA").item(0).getTextContent());
                    ship.setEtd(eElement.getElementsByTagName("ETD").item(0).getTextContent());
                    ship.setCallId(eElement.getElementsByTagName("CallId").item(0).getTextContent());
                    ship.setStatusId(eElement.getElementsByTagName("VesselStatusID").item(0).getTextContent());

                    ship.setCountryCode(this.getCountryCode(eElement.getElementsByTagName("VesselFlag").item(0).getTextContent()));
                    ships.add(ship);

                }
            }


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }


        return ships;
    }




}