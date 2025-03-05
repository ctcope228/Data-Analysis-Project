package components;

import components.standard.Standard;

/**
 * Player data kernel component with primary methods. (Note: by package-wide
 * convention, all references are non-null.)
 *
 * @mathmodel type PlayerDataKernel is modeled by finite set of (String, String)
 *            pairs
 * @initially <pre>
 * ():
 *  ensures
 *   this = {}
 * </pre>
 */
public interface PlayerDataKernel extends Standard<PlayerData> {

    /**
     * Adds the pair ({@code type}, {@code value}) to this.
     *
     * @param stat
     *            the type to be added
     * @param value
     *            the associated value to be added
     * @updates this
     * @ensures this = #this union {(key, value)}
     */
    void addStat(String stat, String value);

    /**
     * Reports whether there is a pair in {@code this} whose first component is
     * {@code key}.
     *
     * @param stat
     *            the stat to be checked
     * @return true iff there is a pair in this whose first component is
     *         {@code stat}
     * @ensures hasStat = (stat is in DOMAIN(this))
     */
    boolean hasStat(String stat);

    /**
     * Reports the value associated with {@code stat} in {@code this}.
     *
     * @param stat
     *            the stat whose associated value is to be reported
     * @return the value associated with stat
     * @aliases reference returned by {@code value}
     * @requires stat is in DOMAIN(this)
     * @ensures (stat, value) is in this
     */
    String value(String stat);
}
