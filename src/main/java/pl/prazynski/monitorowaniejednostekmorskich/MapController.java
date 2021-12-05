package pl.prazynski.monitorowaniejednostekmorskich;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.prazynski.monitorowaniejednostekmorskich.model.TrackService;

@Controller
public class MapController {

    private final TrackService trackService;


    public MapController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping
    public String getMap(Model model){
        model.addAttribute("ports", trackService.getPorts());
        model.addAttribute("vessels", trackService.getShips("Gdynia"));
        return "map";
    }

    @GetMapping("/szczecin")
    public String getMapSzczecin(Model model){
        model.addAttribute("ports", trackService.getPorts());
        model.addAttribute("vessels", trackService.getShips("Szczecin"));
        return "map";
    }

    @GetMapping("/details/port-szczecin")
    public String getDetailsSzczecin(Model model){
        model.addAttribute("port", trackService.getPortDetails("Szczecin"));
        model.addAttribute("vessels", trackService.getShips("Szczecin"));
        return "details";
    }

    @GetMapping("/police")
    public String getMapPolice(Model model){
        model.addAttribute("ports", trackService.getPorts());
        model.addAttribute("vessels", trackService.getShips("Police"));
        return "map";
    }

    @GetMapping("/details/port-police")
    public String getDetailsPolice(Model model){
        model.addAttribute("port", trackService.getPortDetails("Police"));
        model.addAttribute("vessels", trackService.getShips("Police"));
        return "details";
    }

    @GetMapping("/swinoujscie")
    public String getMapSwinoujscie(Model model){
        model.addAttribute("ports", trackService.getPorts());
        model.addAttribute("vessels", trackService.getShips("Swinoujscie"));
        return "map";
    }

    @GetMapping("/details/port-swinoujscie")
    public String getDetailsSwinoujscie(Model model){
        model.addAttribute("port", trackService.getPortDetails("Swinoujscie"));
        model.addAttribute("vessels", trackService.getShips("Swinoujscie"));
        return "details";
    }

    @GetMapping("/gdansk-port-polnocny")
    public String getMapGdanskPolnocny(Model model){
        model.addAttribute("ports", trackService.getPorts());
        model.addAttribute("vessels", trackService.getShips("Gdansk Port Polnocny"));
        return "map";
    }

    @GetMapping("/details/gdansk-port-polnocny")
    public String getDetailsGdanskPolnocny(Model model){
        model.addAttribute("port", trackService.getPortDetails("Gdansk Port Polnocny"));
        model.addAttribute("vessels", trackService.getShips("Gdansk Port Polnocny"));
        return "details";
    }

    @GetMapping("/gdynia")
    public String getMapGdynia(Model model){
        model.addAttribute("ports", trackService.getPorts());
        model.addAttribute("vessels", trackService.getShips("Gdynia"));
        return "map";
    }

    @GetMapping("/details/port-gdynia")
    public String getDetailsGdynia(Model model){
        model.addAttribute("port", trackService.getPortDetails("Gdynia"));
        model.addAttribute("vessels", trackService.getShips("Gdynia"));
        return "details";
    }


    @GetMapping("/gdansk-nowy-port")
    public String getMapGdanskNowy(Model model){
        model.addAttribute("ports", trackService.getPorts());
        model.addAttribute("vessels", trackService.getShips("Gdansk Nowy Port"));
        return "map";
    }

    @GetMapping("/details/gdansk-nowy-port")
    public String getDetailsGdanskNowy(Model model){
        model.addAttribute("port", trackService.getPortDetails("Gdansk Nowy Port"));
        model.addAttribute("vessels", trackService.getShips("Gdansk Nowy Port"));
        return "details";
    }



}
