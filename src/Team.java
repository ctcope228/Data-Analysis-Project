import java.util.ArrayList;
import java.util.List;

import components.playerdata.PlayerData;
import components.playerdata.PlayerData1L;

/**
 * A simple Team that holds a roster of players, each backed by a PlayerData1L
 * (storing stats like points, rebounds, assists).
 */
public class Team {

    /**
     * Name of the team.
     */
    private final String teamName;

    /**
     * List of players.
     */
    private final List<PlayerData> roster;

    /**
     * @param name
     *            the team name
     */
    public Team(String name) {
        this.teamName = name;
        this.roster = new ArrayList<>();
    }

    /**
     * Adds a new player to the roster with the given stats.
     *
     * @param playerName
     *            the player’s name
     * @param ppg
     *            points per game
     * @param rpg
     *            rebounds per game
     * @param apg
     *            assists per game
     */
    public void addPlayer(String playerName, double ppg, double rpg,
            double apg) {
        PlayerData pd = new PlayerData1L();
        pd.addStat("team", this.teamName);
        pd.addStat("name", playerName);
        pd.addStat("points", String.valueOf(ppg));
        pd.addStat("rebounds", String.valueOf(rpg));
        pd.addStat("assists", String.valueOf(apg));
        this.roster.add(pd);
    }

    /**
     * Prints out each player’s per‑game stats.
     */
    public void printRosterStats() {
        System.out.println("Team: " + this.teamName);
        for (PlayerData pd : this.roster) {
            System.out.printf("%s → PPG: %.1f, RPG: %.1f, APG: %.1f%n",
                    pd.value("name"), pd.toDouble("points"),
                    pd.toDouble("rebounds"), pd.toDouble("assists"));
        }
    }
}
