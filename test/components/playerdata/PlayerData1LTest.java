package components.playerdata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test suite for {@link PlayerData1L}, modeling a player's statistical
 * data (e.g., points, rebounds, assists).
 *
 * <p>
 * Each test exercises a primary operation—creation, insertion, replacement,
 * clearing, and transfer—using common stat keys.
 * </p>
 */
public class PlayerData1LTest {

        /** The fixture under test. */
        private PlayerData1L pd;

        /**
         * Creates a new {@code PlayerData1L} before each test.
         */
        @Before
        public void setUp() {
                this.pd = new PlayerData1L();
        }

        /**
         * Tests that {@code newInstance()} returns a new, empty
         * {@code PlayerData1L} of the same runtime type.
         */
        @Test
        public void testNewInstanceIsEmptyAndSameType() {
                PlayerData other = this.pd.newInstance();
                assertNotNull("newInstance() must not return null", other);
                assertTrue("newInstance() must be same runtime type",
                                other instanceof PlayerData1L);
                // Newly created instance should have no stats recorded yet.
                assertFalse("empty instance should report no 'points' stat",
                                other.hasStat("points"));
        }

        /**
         * Tests that {@code addStat} correctly adds a new stat ("points") and
         * that {@code hasStat} and {@code value} reflect the insertion.
         */
        @Test
        public void testAddStatHasStatAndValue() {
                assertFalse("initially no 'points' stat",
                                this.pd.hasStat("points"));
                this.pd.addStat("points", "25");
                assertTrue("after addStat, 'points' must exist",
                                this.pd.hasStat("points"));
                assertEquals("value('points') must equal \"25\"", "25",
                                this.pd.value("points"));
        }

        /**
         * Tests that calling {@code addStat} a second time with the same key
         * ("rebounds") replaces the existing value.
         */
        @Test
        public void testAddStatReplacesExistingValue() {
                this.pd.addStat("rebounds", "10");
                assertEquals("first insert of 'rebounds'", "10",
                                this.pd.value("rebounds"));
                this.pd.addStat("rebounds", "12");
                assertEquals("second insert replaces previous 'rebounds'", "12",
                                this.pd.value("rebounds"));
        }

        /**
         * Tests that {@code clear()} removes all recorded stats (e.g.,
         * "assists").
         */
        @Test
        public void testClear() {
                this.pd.addStat("assists", "8");
                assertTrue("before clear(), 'assists' should exist",
                                this.pd.hasStat("assists"));
                this.pd.clear();
                assertFalse("after clear(), 'assists' should no longer exist",
                                this.pd.hasStat("assists"));
        }

        /**
         * Tests that {@code transferFrom} moves all stats (e.g., "steals" and
         * "blocks") from the source to the destination and leaves the source
         * empty.
         */
        @Test
        public void testTransferFrom() {
                // Prepare source with two basketball stats
                PlayerData1L src = new PlayerData1L();
                src.addStat("steals", "3");
                src.addStat("blocks", "2");
                assertTrue(src.hasStat("steals"));
                assertTrue(src.hasStat("blocks"));

                // Destination starts empty
                PlayerData1L dest = new PlayerData1L();
                assertFalse(dest.hasStat("steals"));
                assertFalse(dest.hasStat("blocks"));

                // Perform transfer
                dest.transferFrom(src);

                // Destination now has both stats
                assertTrue(dest.hasStat("steals"));
                assertTrue(dest.hasStat("blocks"));
                assertEquals("3", dest.value("steals"));
                assertEquals("2", dest.value("blocks"));

                // Source should be cleared
                assertFalse("source should be empty after transfer",
                                src.hasStat("steals"));
                assertFalse("source should be empty after transfer",
                                src.hasStat("blocks"));
        }
}
