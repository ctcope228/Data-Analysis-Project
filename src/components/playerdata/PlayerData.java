package components.playerdata;

/**
 * {@code PlayerDataKernel} enhanced with secondary methods.
 */
public interface PlayerData extends PlayerDataKernel {

    /**
     * Compares the value of a specific stat between this player and another
     * player.
     *
     * @param player
     *            the player to compare against
     * @param stat
     *            the stat to be compared
     * @return {@code -1} if this player's stat value is less than the other
     *         player's, {@code 1} if greater, and {@code 0} if they are equal.
     * @ensures compareStat = -1 if this.stat < player.stat, compareStat = 1 if
     *          this.stat > player.stat, compareStat = 0 if this.stat ==
     *          player.stat
     */
    double compareStat(PlayerData player, String stat);

    /**
     * Reports whether the value of the specified stat can be converted to an
     * {@code double}.
     *
     * @param stat
     *            the stat to check
     * @return {@code true} if the stat value can be parsed as an
     *         {@code double}, {@code false} otherwise
     * @ensures canConvertToDouble = (value(stat) can be successfully parsed as
     *          an double)
     */
    boolean canConvertToDouble(String stat);

    /**
     * Retrieves the value of the specified stat as an {@code double}, if
     * possible.
     *
     * @param stat
     *            the stat to retrieve as an double
     * @return the double representation of the stat value
     * @requires canConvertToDouble(stat)
     * @ensures toDouble = Double.parseDouble(value(stat))
     */
    double toDouble(String stat);
}
