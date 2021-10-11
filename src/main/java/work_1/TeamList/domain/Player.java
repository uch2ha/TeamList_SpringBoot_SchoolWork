package work_1.TeamList.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Player {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long playerId;
	private String firstName, lastName, nickName;
	
	@ManyToOne
	@JoinColumn(name="teamId")
	private Team team;
	
	public Player() { }

	public Player(String firstName, String lastName, String nickName, Team team) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.team = team;
	}

	public long getId() {
		return playerId;
	}

	public void setId(long playerId) {
		this.playerId = playerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	
	
}
