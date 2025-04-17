package components.playerdata;

/**
 * Layered implementations of secondary methods for {@code PlayerData}.
 */
public abstract class PlayerDataSecondary implements PlayerData {

    @Override
    public abstract int compareStat(PlayerDataPoC player, String stat) {
        if (this.canConvertToInt(stat)) {
            int v1 = this.toInt(stat);
        }
        if (player.canConvertToInt(stat)) {
            int v2 = player.toInt(stat);
        }
        // use Integer.compare for clean -1/0/1 semantics
        return Integer.compare(v1, v2);
    }

    @Override
    public abstract boolean canConvertToInt(String stat){
        try {
            Integer.parseInt(this.value(stat));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public abstract int toInt(String stat){
       return Integer.parseInt(this.value(stat));
    }
}
