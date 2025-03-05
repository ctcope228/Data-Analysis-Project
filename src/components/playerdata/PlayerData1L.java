package components;

import components.map.Map1L;

public class PlayerData1L extends PlayerDataSecondary {

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
    public PlayerData1L() {

        this.createNewRep();
    }

    @Override
    public final void addStat(String stat, String value) {
        if (!this.rep.hasKey(stat)) {
            this.rep.add(stat, value);
        } else {
            this.rep.replaceValue(stat, value);
        }
    }

    @Override
    public final boolean hasStat(String stat) {
        return this.rep.hasKey(stat);
    }

    @Override
    public final String value(String stat) {
        return this.rep.value(stat);
    }
}
