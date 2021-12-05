package pl.prazynski.monitorowaniejednostekmorskich.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.prazynski.monitorowaniejednostekmorskich.dao.entity.Port;
import pl.prazynski.monitorowaniejednostekmorskich.manager.PortManager;

import java.util.Optional;

@RestController
@RequestMapping("/api/ports")
public class PortApi {

    private PortManager ports;

    @Autowired
    public PortApi(PortManager ports) {
        this.ports = ports;
    }

    @GetMapping("/all")
    public Iterable<Port> getAll(){
        return ports.findAll();
    }

    @GetMapping("/get/{index}")
    public Optional<Port>  getById(@PathVariable Long index){
        return ports.findById(index);
    }

    @PostMapping
    public Port addPort(@RequestBody Port port){
        return ports.save(port);
    }

    @PutMapping
    public Port updatePort(@RequestBody Port port){
        return ports.save(port);
    }

    @DeleteMapping
    public void deletePort(@RequestParam Long index){
        ports.deleteById(index);
    }
}
