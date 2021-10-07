package work_1.TeamList.domain;

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
	private long gameid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
	private List<Team> teams;
	
	public Game() { }
	

	public Game(String name) {
		super();
		this.name = name;
	}


	public long getGameid() {
		return gameid;
	}


	public void setGameid(long gameid) {
		this.gameid = gameid;
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
	
	
}
