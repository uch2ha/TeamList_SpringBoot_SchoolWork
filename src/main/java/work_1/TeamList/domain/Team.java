package work_1.TeamList.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Team {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long teamid;
		private String name;
		
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
		private List<Player> players;
		
		@ManyToOne
		@JoinColumn(name="gameid")
		private Game game;
		
		public Team() { }
		

		public Team(String name, Game game) {
			super();
			this.name = name;
			this.game = game;
		}

		public long getTeamid() {
			return teamid;
		}

		public void setTeamid(long teamid) {
			this.teamid = teamid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}


		public List<Player> getPlayers() {
			return players;
		}


		public void setPlayers(List<Player> players) {
			this.players = players;
		}


		public Game getGame() {
			return game;
		}


		public void setGame(Game game) {
			this.game = game;
		}
		
		
		
		
		
}
