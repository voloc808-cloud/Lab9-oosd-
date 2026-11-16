package tournament;

public class Round {

    // Aggregation Tournament <>--- * Round: phía "1", gán 1 lần lúc tạo, không đổi nữa
    private final Tournament tournament;

    public Round(Tournament tournament) {
        if (tournament == null) {
            throw new IllegalArgumentException("Round phải thuộc về một Tournament");
        }
        this.tournament = tournament;
        tournament.addRound(this);
    }

    public Tournament getTournament() {
        return tournament;
    }
}
