package tournament;

public class Main {
    public static void main(String[] args) {
        League league = new League();
        Tournament t1 = new Tournament(league);
        Tournament t2 = new Tournament(league);
        Round r1 = new Round(t1);
        Round r2 = new Round(t1);
        Player p1 = new Player();
        Player p2 = new Player();

        t1.addPlayer(p1);          // thêm từ phía Tournament
        p1.addTournament(t2);      // thêm từ phía Player
        t1.addPlayer(p2);
        t1.addPlayer(p2);          // thêm trùng, không bị lặp

        System.out.println("League co " + league.getTournaments().size() + " tournament");
        System.out.println("t1 co " + t1.getRounds().size() + " round, " + t1.getPlayers().size() + " player");
        System.out.println("t2 co " + t2.getRounds().size() + " round, " + t2.getPlayers().size() + " player");
        System.out.println("p1 tham gia " + p1.getTournaments().size() + " tournament");
        System.out.println("r1 thuoc t1: " + (r1.getTournament() == t1) + ", t1 thuoc league: " + (t1.getLeague() == league));

        p1.removeTournament(t1);   // go tu phia Player
        System.out.println("Sau khi p1 roi t1: t1 co " + t1.getPlayers().size() + " player, p1 tham gia " + p1.getTournaments().size() + " tournament");
    }
}
