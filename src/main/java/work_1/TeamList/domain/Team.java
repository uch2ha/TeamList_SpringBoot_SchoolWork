package work_1.TeamList.domain;

import com.sun.istack.NotNull;

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
		private long teamId;

		@NotNull
		private String name;

		@NotNull
		private String webSite;
		
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
		private List<Player> players;
		
		@ManyToOne
		@JoinColumn(name="gameId")
		private Game game;
		
		public Team() { }
		

		public Team(String name,String webSite, Game game) {
			super();
			this.webSite = webSite;
			this.name = name;
			this.game = game;
		}

		public long getTeamId() {
			return teamId;
		}

		public void setTeamId(long teamId) {
			this.teamId = teamId;
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

		public String getWebSite() {
			return webSite;
		}

		public void setWebSite(String webSite) {
			this.webSite = webSite;
		}
}
