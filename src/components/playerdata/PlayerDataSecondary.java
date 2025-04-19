package components.playerdata;

/**
 * Layered implementations of secondary methods for {@code PlayerData}.
 */
public abstract class PlayerDataSecondary implements PlayerData {

    @Override
    public final double compareStat(PlayerData player, String stat) {
        double v1 = this.toDouble(stat);
        double v2 = player.toDouble(stat);

        return Double.compare(v1, v2);
    }

    @Override
    public final boolean canConvertToDouble(String stat) {
        try {
            Double.parseDouble(this.value(stat));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public final double toDouble(String stat) {
        return Double.parseDouble(this.value(stat));
    }
}
