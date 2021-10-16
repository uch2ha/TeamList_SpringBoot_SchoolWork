package work_1.TeamList.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long playerId;

    @NotEmpty(message = "First name may not be empty")
    @Size(min = 2, max = 32, message = "First name must be between 2 and 32 characters long")
    private String firstName;

    @NotEmpty(message = "Last name may not be empty")
    @Size(min = 2, max = 32, message = "Last name must be between 2 and 32 characters long")
    private String lastName;

    @NotEmpty(message = "Nick name may not be empty")
    @Size(min = 2, max = 32, message = "Nick name must be between 2 and 32 characters long")
    private String nickName;

    
    @ManyToOne
    @JoinColumn(name = "teamId")
    private Team team;

    public Player() {
    }

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
