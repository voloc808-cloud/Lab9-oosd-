package tournament;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tournament {

    // Aggregation League <>--- * Tournament: phía "1", gán 1 lần lúc tạo, không đổi nữa
    private final League league;

    // Aggregation Tournament <>--- * Round: phía "nhiều"
    private final List<Round> rounds = new ArrayList<>();

    // Association Tournament * --- * Player: hai chiều, nhiều-nhiều
    private final Set<Player> players = new HashSet<>();

    public Tournament(League league) {
        if (league == null) {
            throw new IllegalArgumentException("Tournament phải thuộc về một League");
        }
        this.league = league;
        league.addTournament(this);
    }

    public League getLeague() {
        return league;
    }

    public List<Round> getRounds() {
        return Collections.unmodifiableList(rounds);
    }

    // Chỉ constructor của Round (cùng package) mới được gọi hàm này
    void addRound(Round round) {
        rounds.add(round);
    }

    public Set<Player> getPlayers() {
        return Collections.unmodifiableSet(players);
    }

    public void addPlayer(Player player) {
        if (player != null && players.add(player)) {
            player.addTournament(this);
        }
    }

    public void removePlayer(Player player) {
        if (player != null && players.remove(player)) {
            player.removeTournament(this);
        }
    }
}
