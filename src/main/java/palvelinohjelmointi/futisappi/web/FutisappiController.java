package palvelinohjelmointi.futisappi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import palvelinohjelmointi.futisappi.domain.ClubRepository;
import palvelinohjelmointi.futisappi.domain.Player;
import palvelinohjelmointi.futisappi.domain.PlayerRepository;
import palvelinohjelmointi.futisappi.domain.PositionRepository;
import javax.validation.Valid;

@Controller
public class FutisappiController {
	
	@Autowired
	private PlayerRepository repository;
	
	@Autowired
	private ClubRepository crepository;
	
	@Autowired
	private PositionRepository posrepository;
	
	@RequestMapping(value = "/index")
	public String futisappi() {
		return "index";
	}
	
	@RequestMapping(value = "/squadbuilder")
	public String squadBuilder() {
		return "squadbuilder";
	}
	
	@RequestMapping(value = "/playerlist")
	public String playerlist(Model model) {
		model.addAttribute("players", repository.findAll());
		return "playerlist";
	}
	
	@GetMapping(value="/playersbyclub/{id}")
    public String playersByClub(@PathVariable("id") Long id, Model model) {	
    	model.addAttribute("club", crepository.findByClubId(id));
       	model.addAttribute("player", repository.findAll());

        return "playersbyclub";
    }
	
	@RequestMapping(value = "/addplayer")
	public String addPlayer(Model model) {
		model.addAttribute("player", new Player());
		model.addAttribute("clubs", crepository.findAll());
		model.addAttribute("positions", posrepository.findAll());
		return "addplayer";
	}
	
	@RequestMapping(value = "/saveplayer", method = RequestMethod.POST)
	public String savePlayer(@Valid Player player, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("clubs", crepository.findAll());
			model.addAttribute("positions", posrepository.findAll());
			return "addplayer";
		}
		repository.save(player);
		return "redirect:playerlist";
	}
	
	@RequestMapping(value = "/editplayer/{id}")
	public String editPlayer(@PathVariable("id") Long id, Model model) {
		
		Player player = repository.findById(id).get();
		model.addAttribute("player", player);
		model.addAttribute("clubs", crepository.findAll());
		model.addAttribute("positions", posrepository.findAll());
		return "editplayer";
	}
	
	@RequestMapping(value = "/editreadyplayer/{id}", method = RequestMethod.POST)
	public String editReadyPlayer(@PathVariable("id") Long id, Player player, Model model, BindingResult result) {
		if (result.hasErrors()) {
            model.addAttribute("clubs", crepository.findAll());
            model.addAttribute("positions", posrepository.findAll());
            return "editplayer";
        }
		player.setId(id);
		repository.save(player);
		return "redirect:/playerlist";
	}
	
	@RequestMapping("/deleteplayer/{id}")
	public String deletePlayer(@PathVariable("id") Long id, Model model) {
	repository.deleteById(id);
	return "redirect:/playerlist";
}
}
