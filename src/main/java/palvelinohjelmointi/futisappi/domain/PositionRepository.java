package palvelinohjelmointi.futisappi.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends CrudRepository<Position, Long>{
	
	List<Position> findByPos(String pos);

}
