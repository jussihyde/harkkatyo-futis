package palvelinohjelmointi.futisappi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import palvelinohjelmointi.futisappi.domain.Club;
import palvelinohjelmointi.futisappi.domain.ClubRepository;
import palvelinohjelmointi.futisappi.domain.Player;
import palvelinohjelmointi.futisappi.domain.PlayerRepository;
import palvelinohjelmointi.futisappi.domain.Position;
import palvelinohjelmointi.futisappi.domain.PositionRepository;
import palvelinohjelmointi.futisappi.domain.User;
import palvelinohjelmointi.futisappi.domain.UserRepository;

@SpringBootApplication
public class FutisappiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FutisappiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PlayerRepository repository, ClubRepository crepository, PositionRepository posrepository, UserRepository urepository)
		
		{return (args) -> {
			final Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);
			
			Club c1 = new Club("FC Barcelona");
			Club c2 = new Club("Manchester City");
			
			crepository.save(c1);
			crepository.save(c2);
			
			crepository.findAll().forEach((club) -> {
				logger.info("{}", club);
			});
			
			Position pos1 = new Position("Goal Keeper", "GK");
			Position pos2 = new Position("Left-Back", "LB");
			Position pos3 = new Position("Centre-Back", "CB");
			Position pos4 = new Position("Right-Back", "RB");
			Position pos5 = new Position("Centre-Defensive-Midfielder", "CDM");
			Position pos6 = new Position("Right-Midfielder", "RM");
			Position pos7 = new Position("Centre-Midfielder", "CM");
			Position pos8 = new Position("Left-Midfielder", "LM");
			Position pos9 = new Position("Centre-Attacking-Midfielder", "CAM");
			Position pos10 = new Position("Left-Winger", "LW");
			Position pos11 = new Position("Right-Winger", "RW");
			Position pos12 = new Position("Centre-Forward", "CF");
			Position pos13 = new Position("Striker", "ST");
			
			posrepository.save(pos1);
			posrepository.save(pos2);
			posrepository.save(pos3);
			posrepository.save(pos4);
			posrepository.save(pos5);
			posrepository.save(pos6);
			posrepository.save(pos7);
			posrepository.save(pos8);
			posrepository.save(pos9);
			posrepository.save(pos10);
			posrepository.save(pos11);
			posrepository.save(pos12);
			posrepository.save(pos13);
			
			posrepository.findAll().forEach((position) -> {
				logger.info("{}", position);
			});
			
			Player p1 = new Player("Robert Lewandowski", 9, crepository.findByName("FC Barcelona").get(0), posrepository.findByPos("ST").get(0));
			Player p2 = new Player("Erling Haaland", 9, crepository.findByName("Manchester City").get(0), posrepository.findByPos("ST").get(0));
			
			repository.save(p1);
			repository.save(p2);
			
			repository.findAll().forEach((player) -> {
				logger.info("{}", player);
			});
			
			User user1 = new User("user", "$2a$10$CvPzuhUj1PUeuu7NcI39vuzrpmA.kVGbI25fL6H/rjVWiExVdh0w.", "USER");
			User user2 = new User("admin", "$2a$10$HmtSaFkom..jGjQ2B8ak8Ou.jqY7Y1zOmwGwpV.ZvLYBPXsVlRKJa", "ADMIN");
			
			urepository.save(user1);
			urepository.save(user2);
			
			urepository.findAll().forEach((user) -> {
				logger.info("{}", user);
			});

		};
	}
}
