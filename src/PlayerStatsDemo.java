import components.playerdata.PlayerData;
import components.playerdata.PlayerData1L;

/**
 * A standalone demo that uses PlayerData1L directly in main.
 */
public class PlayerStatsDemo {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        PlayerData leBron = new PlayerData1L();
        leBron.addStat("name", "LeBron James");
        leBron.addStat("points", "27.1");
        leBron.addStat("rebounds", "7.4");
        leBron.addStat("assists", "7.2");

        System.out.printf("%s: %.1f PPG, %.1f RPG, %.1f APG%n",
                leBron.value("name"), leBron.toDouble("points"),
                leBron.toDouble("rebounds"), leBron.toDouble("assists"));

        // Compare LeBron’s scoring to a peer
        PlayerData jordan = new PlayerData1L();
        jordan.addStat("name", "Michael Jordan");
        jordan.addStat("points", "30.1");

        double cmp = leBron.compareStat(jordan, "points");
        if (cmp < 0) {
            System.out.println(leBron.value("name") + " scores less than "
                    + jordan.value("name"));
        } else if (cmp > 0) {
            System.out.println(leBron.value("name") + " scores more than "
                    + jordan.value("name"));
        } else {
            System.out.println("They score the same PPG.");
        }
    }
}
