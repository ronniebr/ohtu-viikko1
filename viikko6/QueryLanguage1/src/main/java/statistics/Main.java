package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstatistics.herokuapp.com/players.txt"));

        Matcher m = new And(new HasAtLeast(10, "goals"),
                new HasAtLeast(10, "assists"),
                new PlaysIn("PHI"));

        for (Player player : stats.matches(m)) {

            System.out.println(player);
        }
        Matcher l = new Or(new HasFewerThan(10, "goals"),
                new PlaysIn("PHI"));
        System.out.println("Vähemmän kuin 10 maalia tai pelaa PHI");
        for (Player player : stats.matches(l)) {

            System.out.println(player);
        }

        Matcher k = new Not(
                new PlaysIn("PHI"),
                new PlaysIn("BOS"));
        System.out.println("EI PHI, BOS");
        for (Player player : stats.matches(k)) {
            System.out.println(player);
        }
    }
}
