package work_1.TeamList.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import work_1.TeamList.domain.GameRepository;
import work_1.TeamList.domain.Player;
import work_1.TeamList.domain.PlayerRepository;
import work_1.TeamList.domain.Team;
import work_1.TeamList.domain.TeamRepository;

@Controller
public class PlayerController {

	@Autowired
	private PlayerRepository pRepository;
	
	@Autowired
	private TeamRepository tRepository;
	
	@Autowired
	private GameRepository gRepository;
	
	@RequestMapping(value = {"/teamList", "/"}, method = RequestMethod.GET)
	public String playerList(Model model) {
		
		model.addAttribute("games", gRepository.findAll());
		model.addAttribute("teams", tRepository.findAll());
		model.addAttribute("players", pRepository.findAll());
		
		return "teamList";
	}
	
	@RequestMapping(value= "/add")
	public String addTeam(Model model) {
		model.addAttribute("team", new Team());
		model.addAttribute("games", gRepository.findAll());
		return "addTeam";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(Player player) {
		pRepository.save(player);
		return "redirect:/teamList";
	}
	
	@RequestMapping(value="/saveTeam", method = RequestMethod.POST)
	public String save(Team team) {
		tRepository.save(team);
		return "redirect:/teamList";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteTeam(@PathVariable("id") Long teamid, Model model) {
		tRepository.deleteById(teamid);
		return "redirect:../teamList";
	}
}
