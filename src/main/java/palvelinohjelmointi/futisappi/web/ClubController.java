package palvelinohjelmointi.futisappi.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import palvelinohjelmointi.futisappi.domain.Club;
import palvelinohjelmointi.futisappi.domain.ClubRepository;
import palvelinohjelmointi.futisappi.domain.PlayerRepository;



@Controller
public class ClubController {


	@Autowired
	private ClubRepository crepository; 
	
	@Autowired
	private PlayerRepository repository;
			
	@RequestMapping(value="/clublist", method = RequestMethod.GET)
	public String clubList(Model model) {
		model.addAttribute("clubs", crepository.findAll());
		return "clublist";
	}
	
	@RequestMapping(value = "/playersbyclub/{id}")
	public String playersByClub(@PathVariable("id") Long id, Model model) {
		model.addAttribute("club", crepository.findById(id));
		model.addAttribute("player", repository.findAll());
		return "playersbyclub";   
    
} 
	
	@RequestMapping(value = "/addclub")
    public String addClub(Model model){
    	model.addAttribute("club", new Club());
        return "addclub";
    }     
    
    @RequestMapping(value = "/saveclub", method = RequestMethod.POST)
    public String saveClub(@Validated Club club, BindingResult result, Model model){  
        if (result.hasErrors()) {
    		model.addAttribute("clubs", crepository.findAll());
    		return "addmaker";
    	}
        crepository.save(club);
        return "redirect:/clublist";
    }    
    @GetMapping("/deleteclub/{id}")
    public String deleteClub(@PathVariable("id") Long id) {
    	crepository.deleteById(id);
        return "redirect:/clublist";
    }
    @RequestMapping(value = "/editclub/{id}")
	public String editMaker(@PathVariable("id") Long id, Model model) {
		model.addAttribute("club", crepository.findById(id));
		return "editclub";   
    
} 
    @PostMapping("/clubready/{id}")
    public String clubReady(@PathVariable("id") Long id, Model model, Club club) {
    	club.setClubId(id);
    	crepository.save(club);
    	return "redirect:/clublist";
    }
    
 
}