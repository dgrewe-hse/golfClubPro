package de.hse.golfclubmanagement.models;

import de.hse.golfclubmanagement.models.Tournament;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TournamentTest {

    @Test
    void testCreateTournament_Success() {
        Tournament tournament = new Tournament();
        tournament.setId(1L);
        tournament.setName("Spring Tournament");
        tournament.setDate(new Date());

        assertNotNull(tournament.getId());
        assertEquals("Spring Tournament", tournament.getName());
        assertNotNull(tournament.getDate());
    }

    @Test
    void testSetName_NullValue() {
        Tournament tournament = new Tournament();
        assertThrows(IllegalArgumentException.class, () -> tournament.setName(null));
    }

    @Test
    void testSetDate_NullValue() {
        Tournament tournament = new Tournament();
        assertThrows(IllegalArgumentException.class, () -> tournament.setDate(null));
    }

    @Test
    void testEquality() {
        Tournament t1 = new Tournament();
        t1.setId(1L);
        t1.setName("Spring Tournament");
        t1.setDate(new Date());

        Tournament t2 = new Tournament();
        t2.setId(1L);
        t2.setName("Spring Tournament");
        t2.setDate(t1.getDate());

        assertEquals(t1, t2); // Works if equals() and hashCode() are implemented
    }
}
