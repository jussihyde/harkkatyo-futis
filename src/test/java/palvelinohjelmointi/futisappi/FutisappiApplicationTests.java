package palvelinohjelmointi.futisappi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import palvelinohjelmointi.futisappi.web.ClubController;
import palvelinohjelmointi.futisappi.web.FutisappiController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FutisappiApplicationTests {

	@Autowired
	private FutisappiController playerController;
	
	@Test
	void contextLoadsPlayer() {
		assertThat(playerController).isNotNull();
	}
	
	@Autowired
	private ClubController clubController;
	
	@Test
	void contextLoadsClub() {
		assertThat(clubController).isNotNull();
	}

}
