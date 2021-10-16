package work_1.TeamList.Service;

import org.springframework.stereotype.Service;
import work_1.TeamList.domain.Team;

@Service
public class TeamValidationService {
    static public String validateTeam(Team team) {
        String message = "";
        if (team.getWebSite() != null) {
            if (!team.getWebSite().startsWith("https://")) {
                message = "Website should start from https://";
            }
        }
        return message;
    }

}
