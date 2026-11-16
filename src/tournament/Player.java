package tournament;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Player {

    // Association Tournament * --- * Player: hai chiều, nhiều-nhiều
    private final Set<Tournament> tournaments = new HashSet<>();

    public Player() {
    }

    public Set<Tournament> getTournaments() {
        return Collections.unmodifiableSet(tournaments);
    }

    public void addTournament(Tournament tournament) {
        if (tournament != null && tournaments.add(tournament)) {
            tournament.addPlayer(this);
        }
    }

    public void removeTournament(Tournament tournament) {
        if (tournament != null && tournaments.remove(tournament)) {
            tournament.removePlayer(this);
        }
    }
}
