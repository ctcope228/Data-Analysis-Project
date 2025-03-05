package components.playerdata;

import components.map.Map1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class PlayerDataPoC {

    /**
     * Representation of {@code this}.
     */
    private Map1L<String, String> rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {

        this.rep = new Map1L<String, String>();
    }

    /**
     * No-argument constructor.
     */
    public PlayerDataPoC() {

        this.createNewRep();
    }

    public void addStat(String stat, String value) {
        if (!this.rep.hasKey(stat)) {
            this.rep.add(stat, value);
        } else {
            this.rep.replaceValue(stat, value);
        }
    }

    public boolean hasStat(String stat) {
        return this.rep.hasKey(stat);
    }

    public String value(String stat) {
        return this.rep.value(stat);
    }

    public int compareStat(PlayerDataPoC player, String stat) {
        int player1Value = 0;
        int player2Value = 0;
        int compare = 0;

        try {
            player1Value = Integer.parseInt(this.value(stat));
            player2Value = Integer.parseInt(player.value(stat));
        } catch (NumberFormatException e) {
            System.err.println(
                    "Invalid string for parsing to int: " + e.getMessage());
        }

        if (player1Value < player2Value) {
            compare = -1;
        } else if (player1Value > player2Value) {
            compare = 1;
        }

        return compare;
    }

    public static void main(String[] args) {

        SimpleWriter out = new SimpleWriter1L();
        PlayerDataPoC player1 = new PlayerDataPoC();
        PlayerDataPoC player2 = new PlayerDataPoC();

        player1.addStat("Name", "Bob");
        player1.addStat("Team", "Cleveland");
        player1.addStat("Height(in)", "82");
        player1.addStat("Weight(lbs)", "250");

        player2.addStat("Name", "Jeff");
        player2.addStat("Team", "Detroit");
        player2.addStat("Height(in)", "72");
        player2.addStat("Weight(lbs)", "200");

        if (player1.compareStat(player2, "Height(in)") > 0) {
            out.print(player1.value("Name") + " is taller");

        } else if (player1.compareStat(player2, "Height(in)") < 0) {
            out.print(player2.value("Name") + " is taller");

        } else {
            out.print("Both players have the same Height(in)");
        }

        out.close();
    }
}
