package work_1.TeamList.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long gameId;

    @NotEmpty(message = "Name may not be empty")
    @Size(min = 2, max = 32, message = "Name of the Game must be between 2 and 32 characters long")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
    private List<Team> teams;

    public Game() {
    }


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
