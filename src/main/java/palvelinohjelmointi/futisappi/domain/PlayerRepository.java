package palvelinohjelmointi.futisappi.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long>{
	
	List<Player> findByName(String name);
	List<Club> findByClub(Long id);

}