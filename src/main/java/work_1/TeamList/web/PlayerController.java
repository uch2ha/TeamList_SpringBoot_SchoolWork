package work_1.TeamList.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import work_1.TeamList.domain.*;

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
	
	@RequestMapping(value= "/addNewTeam", method = RequestMethod.GET)
	public String addTeam(Model model) {
		model.addAttribute("team", new Team());
		model.addAttribute("games", gRepository.findAll());
		return "addTeam";
	}

	@RequestMapping(value= "/addNewGame", method = RequestMethod.GET)
	public String addGame(Model model) {
		model.addAttribute("game", new Game());
		return "addGame";
	}

	@RequestMapping(value= "/editTeam/{id}", method = RequestMethod.GET)
	public String editTeam(@PathVariable("id") long id, Model model) {
		model.addAttribute("team", tRepository.findById(id));
		//model.addAttribute("player", new Player());
		model.addAttribute("players", pRepository.findAll());
		return "editTeam";
	}

	
	@RequestMapping(value="/savePlayer", method = RequestMethod.POST)
	public String savePlayer(Player player) {
		pRepository.save(player);
		return "redirect:/teamList";
	}
	
	@RequestMapping(value="/saveTeam", method = RequestMethod.POST)
	public String saveTeam(Team team) {
		tRepository.save(team);
		return "redirect:/teamList";
	}

	@RequestMapping(value="/updateTeam/{id}", method = RequestMethod.POST)
	public String updateTeam(@PathVariable("id") long id, Team team) {
		tRepository.save(team);
		return "redirect:/teamList";
	}

	@RequestMapping(value="/saveGame", method = RequestMethod.POST)
	public String saveGame(Game game) {
		gRepository.save(game);
		return "redirect:/teamList";
	}
	
	@RequestMapping(value="/deleteTeam/{id}", method = RequestMethod.GET)
	public String deleteTeam(@PathVariable("id") Long teamId, Model model) {
		tRepository.deleteById(teamId);
		return "redirect:../teamList";
	}

	@RequestMapping(value="/deleteGame/{id}", method = RequestMethod.GET)
	public String deleteGame(@PathVariable("id") Long gameId, Model model) {
		gRepository.deleteById(gameId);
		return "redirect:../teamList";
	}
}
