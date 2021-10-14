package work_1.TeamList.domain;

import com.sun.istack.NotNull;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long gameId;

	@NotNull
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
	private List<Team> teams;
	
	public Game() { }
	

	public Game(String name) {
		super();
		this.name = name;
	}


	public long getGameId() {
		return gameId;
	}


	public void setGameId(long gameId) {
		this.gameId = gameId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Team> getTeams() {
		return teams;
	}


	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
	@Override
	public String toString() {
		// Do not insert list attribute students here! Otherwise execution of this method causes an infinite loop. 
		return "Game [gameId=" + gameId + ", name=" + name + "]";
	}
	
	
}
