package components.playerdata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for the secondary methods in {@link PlayerDataSecondary},
 * exercised via the concrete {@link PlayerData1L} implementation. Uses stat
 * keys (e.g., "ppg", "rebounds", "assists").
 */
public class PlayerDataTest {

    /** fixture under test. */
    private PlayerData1L pd1;
    /** fixture under test. */
    private PlayerData1L pd2;

    /** Initialize two new player‑data objects before each test. */
    @Before
    public void setUp() {
        this.pd1 = new PlayerData1L();
        this.pd2 = new PlayerData1L();
    }

    /**
     * canConvertToDouble should return true for a well‑formed decimal string.
     */
    @Test
    public void testCanConvertToDoubleValid() {
        this.pd1.addStat("fg%", "45.5");
        assertTrue("45.5 is a valid double",
                this.pd1.canConvertToDouble("fg%"));
    }

    /**
     * canConvertToDouble should return false for a non‑numeric string.
     */
    @Test
    public void testCanConvertToDoubleInvalid() {
        this.pd1.addStat("playerName", "Jordan");
        assertFalse("Jordan is not a valid double",
                this.pd1.canConvertToDouble("playerName"));
    }

    /**
     * toDouble should parse a valid numeric stat correctly.
     */
    @Test
    public void testToDoubleValid() {
        this.pd1.addStat("ppg", "27.3");
        assertEquals(27.3, this.pd1.toDouble("ppg"), 1e-8);
    }

    /**
     * toDouble should throw NumberFormatException on invalid numeric strings.
     */
    @Test(expected = NumberFormatException.class)
    public void testToDoubleInvalidThrows() {
        this.pd1.addStat("team", "Lakers");
        this.pd1.toDouble("team");
    }

    /**
     * compareStat should return a negative result when this &lt; other.
     */
    @Test
    public void testCompareStatLess() {
        this.pd1.addStat("rebounds", "7.2");
        this.pd2.addStat("rebounds", "10.1");
        assertEquals(-1.0, this.pd1.compareStat(this.pd2, "rebounds"), 0.0);
    }

    /**
     * compareStat should return zero when this == other.
     */
    @Test
    public void testCompareStatEqual() {
        this.pd1.addStat("assists", "8.0");
        this.pd2.addStat("assists", "8.0");
        assertEquals(0.0, this.pd1.compareStat(this.pd2, "assists"), 0.0);
    }

    /**
     * compareStat should return a positive result when this &gt; other.
     */
    @Test
    public void testCompareStatGreater() {
        this.pd1.addStat("steals", "2.5");
        this.pd2.addStat("steals", "1.0");
        assertEquals(1.0, this.pd1.compareStat(this.pd2, "steals"), 0.0);
    }

    /**
     * compareStat should propagate NumberFormatException if either stat cannot
     * be parsed as a double.
     */
    @Test(expected = NumberFormatException.class)
    public void testCompareStatInvalidThrows() {
        this.pd1.addStat("blocks", "3X");
        this.pd2.addStat("blocks", "4.2");
        this.pd1.compareStat(this.pd2, "blocks");
    }
}
