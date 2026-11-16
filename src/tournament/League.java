package tournament;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League {

    // Aggregation League <>--- * Tournament: League chứa danh sách các Tournament
    private final List<Tournament> tournaments = new ArrayList<>();

    public League() {
    }

    public List<Tournament> getTournaments() {
        return Collections.unmodifiableList(tournaments);
    }

    // Chỉ constructor của Tournament (cùng package) mới được gọi hàm này
    void addTournament(Tournament tournament) {
        tournaments.add(tournament);
    }
}
