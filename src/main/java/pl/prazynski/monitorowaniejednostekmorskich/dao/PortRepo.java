package pl.prazynski.monitorowaniejednostekmorskich.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.prazynski.monitorowaniejednostekmorskich.dao.entity.Port;

import java.util.List;

@Repository
public interface PortRepo extends CrudRepository<Port, Long>{


}
