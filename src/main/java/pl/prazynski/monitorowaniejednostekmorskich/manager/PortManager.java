package pl.prazynski.monitorowaniejednostekmorskich.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.prazynski.monitorowaniejednostekmorskich.dao.PortRepo;
import pl.prazynski.monitorowaniejednostekmorskich.dao.entity.Port;
import pl.prazynski.monitorowaniejednostekmorskich.model.Point;

import java.util.Optional;

@Service
public class PortManager {
    private PortRepo portRepo;

    @Autowired
    public PortManager(PortRepo portRepo) {
        this.portRepo = portRepo;
    }

    public Optional<Port> findById(Long id){
        return portRepo.findById(id);
    }

    public Iterable<Port> findAll(){
        return portRepo.findAll();
    }

    public Port save(Port port){
        return portRepo.save(port);
    }

    public void deleteById(Long id){
        portRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        save(new Port(1L, "Port Gdynia", "PLGDY", 54.5280556, 18.5236111, "755,4 ha (7,55 km²)", "1923", "https://player.webcamera.pl/gdynia_cam_e257dc", "Handlowy port morski nad Zatoką Gdańską, w woj. pomorskim w Gdyni, położony na Pobrzeżu Kaszubskim. Jest trzecim co do wielkości portem morskim w Polsce (po Gdańsku i Szczecinie)."));
        save(new Port(2L,  "Gdańsk Port Północny", "PLGDN", 54.3670349, 18.6831017, "nieznany", "nieznany", "https://www.portgdansk.pl/port/kamery/widok-na-wejscie-do-portu-wewnetrznego/", "Jedyny polski port zdolny obsługiwać statki o największym dopuszczalnym w cieśninach duńskich zanurzeniu 15 m."));
        save(new Port(3L, "Gdańsk Nowy Port", "PLNOW", 54.4015028, 18.665270666260348, "nieznany", "nieznany", "https://www.portgdansk.pl/port/kamery/widok-na-kanal-portowy/", "Część portu morskiego Gdańsk" ));
        save(new Port(4L, "Port Świnoujście", "PLSWI", 53.9073734, 14.2495233, "nieznany","nieznany","http://88.218.254.213:8092/player.html","Port morski położony nad Zatoką Pomorską, na południowym wybrzeżu Morza Bałtyckiego, na wyspach Uznam i Wolin. W porcie znajduje się nabrzeże przeładunkowe, terminal LNG, terminal pasażerski oraz przystań jachtowa." ));
        save(new Port(5L, "Port Police", "PLPLC", 53.573516049999995, 14.558458041456134, "7 000 m²", "1967", "brak", "Port morski i rzeczny na Odrze przy torze wodnym Świnoujście–Szczecin. Jest 5. portem w Polsce pod względem wielkości przeładunku."));
        save(new Port(6L, "Port Szczecin", "PLSZZ", 53.4131022, 14.5660693,"nieznany", "nieznany", "https://lantech.com.pl/liveszczecin/lasztownia/", "Handlowy port morski i rzeczny. Port obsługuje transporty ładunków drobnicowych – w tym kontenery, wyroby hutnicze i ładunki wielkogabarytowe, jak i ładunków masowych – suchych i płynnych."));

    }
}
