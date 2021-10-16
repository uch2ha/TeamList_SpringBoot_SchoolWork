package work_1.TeamList.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long teamId;

    @NotEmpty(message = "Team name may not be empty")
    @Size(min = 2, max = 32, message = "Team name must be between 2 and 32 characters long")
    private String name;

    @NotNull
    private String webSite;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private List<Player> players;

    @ManyToOne
    @JoinColumn(name = "gameId")
    private Game game;

    public Team() {
    }


    public Team(String name, String webSite, Game game) {
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
