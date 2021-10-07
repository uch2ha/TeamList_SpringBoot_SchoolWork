package work_1.TeamList.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import work_1.TeamList.domain.PlayerRepository;
import work_1.TeamList.domain.TeamRepository;

@Controller
public class PlayerController {

	@Autowired
	private PlayerRepository pRepository;
	
	@Autowired
	private TeamRepository tRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String playerList(Model model) {
		
		model.addAttribute("players", pRepository.findAll());
		
		return "home";
	}
}
