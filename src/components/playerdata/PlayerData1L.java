package components.playerdata;

import components.map.Map1L;

/**
 * {@code PlayerData} represented as a {@link Map<String, String>} with
 * implementations of primary methods.
 *
 * @convention this.rep != null
 * @correspondence this = { ⟨k, v⟩ | k ∈ rep.stat() ∧ v = rep.value(k) }
 */
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

    /*
     * Standard methods -------------------------------------------------------
     */

    @Override
    public final PlayerData newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(PlayerData source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof PlayerData1L : ""
                + "Violation of: source is of dynamic type PlayerData1L";
        /*
         * This cast cannot fail since the assert above would have stopped
         * execution in that case.
         */
        PlayerData1L localSource = (PlayerData1L) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

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
