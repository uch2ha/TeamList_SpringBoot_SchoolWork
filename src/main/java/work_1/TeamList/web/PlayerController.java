package work_1.TeamList.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import work_1.TeamList.Service.TeamValidationService;
import work_1.TeamList.domain.*;

import javax.validation.Valid;
import java.util.Optional;

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


    @RequestMapping(value = "/addNewGame", method = RequestMethod.GET)
    public String addGame(Model model) {
        model.addAttribute("game", new Game());
        return "addGame";
    }

    @RequestMapping(value = "/addNewTeam", method = RequestMethod.GET)
    public String addTeam(Model model) {
        model.addAttribute("team", new Team());
        model.addAttribute("games", gRepository.findAll());
        return "addTeam";
    }

    @RequestMapping(value = "/addNewPlayer/{id}", method = RequestMethod.GET)
    public String addPlayer(@PathVariable long id, Model model) {
        model.addAttribute("teamId", tRepository.findById(id).get().getTeamId());
        model.addAttribute("player", new Player());
        return "addPlayer";
    }


    @RequestMapping(value = "/editTeam/{id}", method = RequestMethod.GET)
    public String editTeam(@PathVariable("id") long id, Model model) {

        model.addAttribute("team", tRepository.findById(id));
        model.addAttribute("games", gRepository.findAll());

        return "editTeam";
    }

    @RequestMapping(value = "/editPlayer/{id}", method = RequestMethod.GET)
    public String editPlayer(@PathVariable("id") long id, Model model) {

        model.addAttribute("player", pRepository.findById(id));

        return "editPlayer";
    }


    @RequestMapping(value = "/saveGame", method = RequestMethod.POST)
    public String saveGame(@Valid Game game, BindingResult result) {
        if (result.hasErrors()) {
            return "addGame";
        }

        gRepository.save(game);
        return "redirect:/teamList";

    }

    @RequestMapping(value = "/saveTeam", method = RequestMethod.POST)
    public String saveTeam(@Valid Team team, BindingResult result, Model model) {
        //fix the problem, that the game list is not shown after error situation
        model.addAttribute("games", gRepository.findAll());

        //checks if the beginning of the site is specified correctly
        String err = TeamValidationService.validateTeam(team);
        if (!err.isEmpty()) {
            ObjectError error = new ObjectError("globalError", err);
            result.addError(error);
        }

        if (result.hasErrors()) {
            return "addTeam";
        }

        tRepository.save(team);
        return "redirect:/teamList";

    }

    @RequestMapping(value = "/savePlayer/{id}", method = RequestMethod.POST)
    public String savePlayer(@Valid Player player, BindingResult result, @PathVariable long id, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("teamId", tRepository.findById(id).get().getTeamId());
            return "addPlayer";
        }


        Player newPlayer = new Player();
        newPlayer.setFirstName(player.getFirstName());
        newPlayer.setNickName(player.getNickName());
        newPlayer.setLastName(player.getLastName());
        newPlayer.setTeam(tRepository.findById(id).get());
        pRepository.save(newPlayer);
        return "redirect:/teamList";

    }


    @PostMapping("/updateTeamInfo/{id}")
    public String updateTeam(@Valid Team newTeam, BindingResult result, @PathVariable Long id, Model model) {
        //fix the problem, that the game list is not shown after error situation
        model.addAttribute("games", gRepository.findAll());

        //checks if the beginning of the site is specified correctly
        String err = TeamValidationService.validateTeam(newTeam);
        if (!err.isEmpty()) {
            ObjectError error = new ObjectError("globalError", err);
            result.addError(error);
        }

        if (result.hasErrors()) {
            //fix "0" id problem after error situation
            model.addAttribute("teamId", tRepository.findById(id).get().getTeamId());
            return "errors/errorEditTeam";
        } else {
            Optional<Team> oldTeam = tRepository.findById(id);
            oldTeam.get().setName(newTeam.getName());
            oldTeam.get().setWebSite(newTeam.getWebSite());
            oldTeam.get().setGame(newTeam.getGame());

            tRepository.save(oldTeam.get());
            return "redirect:/teamList";
        }

    }

    @PostMapping("/updatePlayerInfo/{id}")
    public String updatePlayer(@Valid Player newPlayer, BindingResult result, @PathVariable Long id) {

        if (result.hasErrors()) {
            return "errors/errorEditPlayer";
        } else {
            Optional<Player> oldPlayer = pRepository.findById(id);
            oldPlayer.get().setFirstName(newPlayer.getFirstName());
            oldPlayer.get().setNickName(newPlayer.getNickName());
            oldPlayer.get().setLastName(newPlayer.getLastName());

            pRepository.save(oldPlayer.get());
            return "redirect:/teamList";
        }

    }

    @RequestMapping(value = "/deleteGame/{id}", method = RequestMethod.GET)
    public String deleteGame(@PathVariable("id") Long gameId, Model model) {
        gRepository.deleteById(gameId);
        return "redirect:../teamList";
    }

    @RequestMapping(value = "/deleteTeam/{id}", method = RequestMethod.GET)
    public String deleteTeam(@PathVariable("id") Long teamId, Model model) {
        tRepository.deleteById(teamId);
        return "redirect:../teamList";
    }

    @RequestMapping(value = "/deletePlayer/{id}", method = RequestMethod.GET)
    public String deletePlayer(@PathVariable Long id, Model model) {
        pRepository.deleteById(id);
        return "redirect:../teamList";
    }


}
