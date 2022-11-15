package palvelinohjelmointi.futisappi.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import palvelinohjelmointi.futisappi.domain.Club;
import palvelinohjelmointi.futisappi.domain.ClubRepository;
import palvelinohjelmointi.futisappi.domain.Player;
import palvelinohjelmointi.futisappi.domain.PlayerRepository;

@Controller
public class FutisRestController {
	
	@Autowired
	private PlayerRepository repository;
	
	@Autowired
	private ClubRepository crepository;
	
	//RESTful element for listing all players
	@RequestMapping(value="/players", method = RequestMethod.GET)
	public @ResponseBody List<Player> playerListRest() {
		return (List<Player>) repository.findAll();
	}
	//RESTful element for listing all clubs
	@RequestMapping(value="/clubs", method = RequestMethod.GET)
	public @ResponseBody List<Club> clubListRest() {
		return (List<Club>) crepository.findAll();
	}
	
	//RESTful GET for single items
	@RequestMapping(value="/players/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Player> findPlayerRest(@PathVariable("id") Long id) {
		return repository.findById(id);
	}
	
	@RequestMapping(value="/clubs/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Club> findClubRest(@PathVariable("id") Long clubId) {
		return crepository.findById(clubId);
	}
	
	//RESTful POST elements
	@RequestMapping(value="/players", method = RequestMethod.POST)
	@ResponseBody Player savePlayerRest(@RequestBody Player player) {
		return repository.save(player);
	}
	
	@RequestMapping(value="/clubs", method = RequestMethod.POST)
	@ResponseBody Club saveClubRest(@RequestBody Club club) {
		return crepository.save(club);
	}
	
	//RESTful DELETE elements
	@DeleteMapping("/players/{id}")
    public @ResponseBody void deletePlayerRest(@PathVariable("id") Long id) {
    	repository.deleteById(id);
    }
	
	@DeleteMapping("/clubs/{id}")
    public @ResponseBody void deleteClubRest(@PathVariable("id") Long clubId) {
    	crepository.deleteById(clubId);
    }
	
	

}
