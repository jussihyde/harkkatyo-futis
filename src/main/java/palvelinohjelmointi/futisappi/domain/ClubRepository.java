package palvelinohjelmointi.futisappi.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ClubRepository extends CrudRepository<Club, Long>{
	
	List<Club> findByName(String name);
	List<Club> findByClubId(Long clubId);
	

}
