package palvelinohjelmointi.futisappi;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import palvelinohjelmointi.futisappi.domain.Club;
import palvelinohjelmointi.futisappi.domain.ClubRepository;
import palvelinohjelmointi.futisappi.domain.Player;
import palvelinohjelmointi.futisappi.domain.PlayerRepository;
import palvelinohjelmointi.futisappi.domain.PositionRepository;
import palvelinohjelmointi.futisappi.domain.User;
import palvelinohjelmointi.futisappi.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class DatabaseTests {
	
	@Autowired
	private PlayerRepository repository;
	
	@Autowired
	private ClubRepository crepository;
	
	@Autowired
	private PositionRepository prepository;
	
	@Autowired
	private UserRepository urepository;

	@Test
	public void findByNameShouldReturnPlayer() {
		List<Player> players = repository.findByName("Robert Lewandowski");
		
		assertThat(players).hasSize(1);
		assertThat(players.get(0).getNumber()).isEqualTo(9);
	}
	
	@Test
	public void findByNameShouldReturnClub() {
		List<Club> clubs = crepository.findByName("Manchester City");
		
		assertThat(clubs).hasSize(1);
		assertThat(clubs.get(0).getClubId()).isEqualTo((long) 02);
	}
	
	@Test
	public void createNewPlayer() {
		Player player = new Player("Ederson", 1, crepository.findByName("Manchester City").get(0), prepository.findByPos("GK").get(0));
		repository.save(player);
		
		assertThat(player.getId()).isNotNull();
	}
	
	@Test
	public void createNewClub() {
		Club club = new Club("PSG");
		crepository.save(club);
		
		assertThat(club.getClubId()).isNotNull();
	}
	
	@Test
	public void createNewUser() {
		User user = new User("visitor", "$2a$10$QDIdolRvkutvG6O6OkldwO25S/.NJ286IhMtSbX./Oo2zBT/nPX0S", "USER");
		urepository.save(user);
		
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void deletePlayer() {
		Long id = (long) 01;
		
		repository.deleteById(id);
		
		assertThat(repository.findById((long) 01).isEmpty());
	}
	
	@Test
	public void deleteClub() {
		Long clubId = (long) 01;
		
		crepository.deleteById(clubId);
		
		assertThat(crepository.findById((long) 01).isEmpty());
	}
}
