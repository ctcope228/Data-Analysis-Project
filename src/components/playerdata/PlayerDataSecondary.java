package components.playerdata;

/**
 * Layered implementations of secondary methods for {@code PlayerData}.
 */
public abstract class PlayerDataSecondary implements PlayerData {

    @Override
    public abstract double compareStat(PlayerDataPoC player, String stat) {
        double v1 = this.toDouble(stat);
        double v2 = player.toDouble(stat);

        return Double.compare(v1, v2);
    }

    @Override
    public abstract boolean canConvertToDouble(String stat) {
        try {
            Double.parseDouble(this.value(stat));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public abstract double toDouble(String stat) {
       return Double.parseDouble(this.value(stat));
    }
}
