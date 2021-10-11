package work_1.TeamList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import work_1.TeamList.domain.Game;
import work_1.TeamList.domain.GameRepository;
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
	public CommandLineRunner demo(PlayerRepository PlayerRepository, TeamRepository TeamRepository, GameRepository GameRepository) {
		return (args) -> {
			//creation default games -->
			Game Dota2 = new Game("Dota2");
			Game CsGo = new Game("Cs:Go");
			Game LoL = new Game("League of Legends");
			
			GameRepository.save(Dota2);
			GameRepository.save(CsGo);
			GameRepository.save(LoL);
			// <--
			
			//creating default teams -->
			Team Secret = new Team("Team Secret", "https://teamsecret.gg/", GameRepository.findByName("Dota2").get(0));
			Team VP_dota = new Team("VP", "https://virtus.pro/en", GameRepository.findByName("Dota2").get(0));
			Team EG = new Team("Evil Geniuses", "https://evilgeniuses.gg/", GameRepository.findByName("Dota2").get(0));
			Team IG = new Team("Invictus Gaming", "https://www.igaming.com.cn/", GameRepository.findByName("Dota2").get(0));

			TeamRepository.save(Secret);
			TeamRepository.save(VP_dota);
			TeamRepository.save(EG);
			TeamRepository.save(IG);
			
			
			Team Navi = new Team("Natus Vincere", "https://navi.gg/en/", GameRepository.findByName("Cs:Go").get(0));
			Team Liquid = new Team("Team Liquid", "https://www.teamliquid.com/", GameRepository.findByName("Cs:Go").get(0));
			Team VP_csGo = new Team("Virtus.pro", "https://virtus.pro/en", GameRepository.findByName("Cs:Go").get(0));
			Team G2 = new Team("G2 Esports", "https://g2esports.com/", GameRepository.findByName("Cs:Go").get(0));
			
			TeamRepository.save(Navi);
			TeamRepository.save(Liquid);
			TeamRepository.save(VP_csGo);
			TeamRepository.save(G2);
			
			Team DWG = new Team("DWG KIA", "https://dwgkia.gg/", GameRepository.findByName("League of Legends").get(0));
			
			TeamRepository.save(DWG);

			// <--
			
			
			//creating default players for Dota2 team -->
			//VP team
			Player Nightfall = new Player("Egor","Grigorenko", "Nightfall", TeamRepository.findByName("VP").get(0));
			Player gpk = new Player("Danil","Skutin", "gpk", TeamRepository.findByName("VP").get(0));
			Player DM = new Player("Dmitry","Dorokhin", "DM", TeamRepository.findByName("VP").get(0));
			Player Kingslayer = new Player("Illias","Ganeev", "Kingslayer", TeamRepository.findByName("VP").get(0));
			Player Save = new Player("Vitalie","Melnic", "Save", TeamRepository.findByName("VP").get(0));
			
			PlayerRepository.save(Nightfall);
			PlayerRepository.save(gpk);
			PlayerRepository.save(DM);
			PlayerRepository.save(Kingslayer);
			PlayerRepository.save(Save);
			
			//EG team
			Player Arteezy = new Player("Artour","Babaev", "Arteezy", TeamRepository.findByName("Evil Geniuses").get(0));
			Player Abed = new Player("Abed","Yusop", "Abed", TeamRepository.findByName("Evil Geniuses").get(0));
			Player iceiceice = new Player("Daryl Koh","Pei Xiang", "iceiceice", TeamRepository.findByName("Evil Geniuses").get(0));
			Player Cr1t = new Player("Andreas","Nielsen", "Cr1t-", TeamRepository.findByName("Evil Geniuses").get(0));
			Player Fly = new Player("Tal","Aizik", "Fly", TeamRepository.findByName("Evil Geniuses").get(0));
			
			PlayerRepository.save(Arteezy);
			PlayerRepository.save(Abed);
			PlayerRepository.save(iceiceice);
			PlayerRepository.save(Cr1t);
			PlayerRepository.save(Fly);
			
			//IG team
			Player flyfly = new Player("Jin","Zhiyi", "flyfly", TeamRepository.findByName("Invictus Gaming").get(0));
			Player Emo = new Player("Zhou","Yi", "Emo", TeamRepository.findByName("Invictus Gaming").get(0));
			Player JT = new Player("Thiay","Jun Wen", "JT", TeamRepository.findByName("Invictus Gaming").get(0));
			Player Kaka = new Player("Hu","Liangzhi", "Kaka-", TeamRepository.findByName("Invictus Gaming").get(0));
			Player Oli = new Player("Chan","Chon Kien", "Oli", TeamRepository.findByName("Invictus Gaming").get(0));
			
			PlayerRepository.save(flyfly);
			PlayerRepository.save(Emo);
			PlayerRepository.save(JT);
			PlayerRepository.save(Kaka);
			PlayerRepository.save(Oli);
			
			//Secret team
			Player MATUMBAMAN = new Player("Lasse","Urpalainen", "MATUMBAMAN", TeamRepository.findByName("Team Secret").get(0));
			Player Nisha = new Player("Michal","Jankowski", "Nisha", TeamRepository.findByName("Team Secret").get(0));
			Player zai = new Player("Ludwig","Wåhlberg", "zai", TeamRepository.findByName("Team Secret").get(0));
			Player YapzOr = new Player("Yazied","Jaradat", "YapzOr", TeamRepository.findByName("Team Secret").get(0));
			Player Puppey = new Player("Clement","Ivanov", "Puppey", TeamRepository.findByName("Team Secret").get(0));
			
			PlayerRepository.save(MATUMBAMAN);
			PlayerRepository.save(Nisha);
			PlayerRepository.save(zai);
			PlayerRepository.save(YapzOr);
			PlayerRepository.save(Puppey);
			// <--
			
			//creating default players for Dota2 team -->
			//Natus Vincere team
			Player s1mple = new Player("Oleksandr","Kostyliev", "s1mple", TeamRepository.findByName("Natus Vincere").get(0));
			Player electronic = new Player("Michal","Jankowski", "electronic", TeamRepository.findByName("Natus Vincere").get(0));
			Player Boombl4 = new Player("Ludwig","Wåhlberg", "Boombl4", TeamRepository.findByName("Natus Vincere").get(0));
			Player Perfecto = new Player("Yazied","Jaradat", "Perfecto", TeamRepository.findByName("Natus Vincere").get(0));
			Player b1t = new Player("Clement","Ivanov", "b1t", TeamRepository.findByName("Natus Vincere").get(0));
			
			PlayerRepository.save(s1mple);
			PlayerRepository.save(electronic);
			PlayerRepository.save(Boombl4);
			PlayerRepository.save(Perfecto);
			PlayerRepository.save(b1t);
			
			//Team Liquid team
			Player EliGE = new Player("Jonathan","Jablonowski", "EliGE", TeamRepository.findByName("Team Liquid").get(0));
			Player NAF = new Player("Keith","Keith", "NAF", TeamRepository.findByName("Team Liquid").get(0));
			Player Stewie2K = new Player("Jacky","Yip", "Stewie2K", TeamRepository.findByName("Team Liquid").get(0));
			Player Grim = new Player("Michael","Wince", "Grim", TeamRepository.findByName("Team Liquid").get(0));
			Player FalleN = new Player("Gabriel","Toledo", "FalleN", TeamRepository.findByName("Team Liquid").get(0));
			
			PlayerRepository.save(EliGE);
			PlayerRepository.save(NAF);
			PlayerRepository.save(Stewie2K);
			PlayerRepository.save(Grim);
			PlayerRepository.save(FalleN);
			
			//Virtus.pro team
			Player buster = new Player("Timur","Tulepov", "buster", TeamRepository.findByName("Virtus.pro").get(0));
			Player qikert = new Player("Alexey","Golubev", "qikert", TeamRepository.findByName("Virtus.pro").get(0));
			Player Jame = new Player("Dzhami","Ali", "Jame", TeamRepository.findByName("Virtus.pro").get(0));
			Player SANJI = new Player("Sanjar","Kuliev", "SANJI", TeamRepository.findByName("Virtus.pro").get(0));
			Player YEKINDAR = new Player("Mareks","Gaļinskis", "YEKINDAR", TeamRepository.findByName("Virtus.pro").get(0));
			
			PlayerRepository.save(buster);
			PlayerRepository.save(qikert);
			PlayerRepository.save(Jame);
			PlayerRepository.save(SANJI);
			PlayerRepository.save(YEKINDAR);
			
			//G2 Esports team
			Player JaCkz = new Player("Audric","Jug", "JaCkz", TeamRepository.findByName("G2 Esports").get(0));
			Player AmaNEk = new Player("François","Delaunay", "AmaNEk", TeamRepository.findByName("G2 Esports").get(0));
			Player nexa = new Player("Nemanja","Isaković", "nexa", TeamRepository.findByName("G2 Esports").get(0));
			Player huNter = new Player("Nemanja","Kovač", "huNter-", TeamRepository.findByName("G2 Esports").get(0));
			Player NiKo = new Player("Nikola","Kovač", "NiKo", TeamRepository.findByName("G2 Esports").get(0));
			
			PlayerRepository.save(JaCkz);
			PlayerRepository.save(AmaNEk);
			PlayerRepository.save(nexa);
			PlayerRepository.save(huNter);
			PlayerRepository.save(NiKo);
			
			//creating default players for LoL team -->
			//DWG KIA team
			Player BeryL = new Player("Cho","Geon-hee", "BeryL", TeamRepository.findByName("DWG KIA").get(0));
			Player ShowMaker = new Player("Heo","Su", "ShowMaker", TeamRepository.findByName("DWG KIA").get(0));
			Player Canyon = new Player("Kim","Geon-bu", "Canyon", TeamRepository.findByName("DWG KIA").get(0));
			Player Ghost = new Player("Jang","Yong-jun", "Ghost", TeamRepository.findByName("DWG KIA").get(0));
			Player Khan = new Player("Kim","Dong-ha", "Khan", TeamRepository.findByName("DWG KIA").get(0));
			
			PlayerRepository.save(BeryL);
			PlayerRepository.save(ShowMaker);
			PlayerRepository.save(Canyon);
			PlayerRepository.save(Ghost);
			PlayerRepository.save(Khan);
			
			
		};
	}

}
