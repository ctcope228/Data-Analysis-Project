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
    int compareStat(PlayerDataPoC player, String stat);

    /**
     * Reports whether the value of the specified stat can be converted to an
     * {@code int}.
     *
     * @param stat
     *            the stat to check
     * @return {@code true} if the stat value can be parsed as an {@code int},
     *         {@code false} otherwise
     * @ensures canConvertToInt = (value(stat) can be successfully parsed as an
     *          int)
     */
    boolean canConvertToInt(String stat);

    /**
     * Retrieves the value of the specified stat as an {@code int}, if possible.
     *
     * @param stat
     *            the stat to retrieve as an integer
     * @return the integer representation of the stat value
     * @requires canConvertToInt(stat)
     * @ensures toInt = Integer.parseInt(value(stat))
     */
    int toInt(String stat);
}
