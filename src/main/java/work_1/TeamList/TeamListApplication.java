package work_1.TeamList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import work_1.TeamList.domain.Player;
import work_1.TeamList.domain.PlayerRepository;
import work_1.TeamList.domain.Team;
import work_1.TeamList.domain.TeamRepository;

@SpringBootApplication
public class TeamListApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamListApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PlayerRepository PlayerRepository, TeamRepository TeamRepository) {
		return (args) -> {
			Team Navi = new Team("Navi");
			Team VP = new Team("VP");
			
			TeamRepository.save(Navi);
			TeamRepository.save(VP);
			
			Player Dendi = new Player("Danil","LastName", "Dendi", "18", TeamRepository.findByName("Navi").get(0));
			Player Aloha = new Player("Alo","Ha", "Aloha", "25", TeamRepository.findByName("VP").get(0));
			
			PlayerRepository.save(Dendi);
			PlayerRepository.save(Aloha);
			
			

			
			
		};
	}

}
