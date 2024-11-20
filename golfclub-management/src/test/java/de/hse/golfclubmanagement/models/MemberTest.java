package de.hse.golfclubmanagement.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class MemberTest {

    @Test
    public void testSetId() {
        Member member = new Member();

        // Boundary value: valid positive ID
        member.setId(1L);
        assertEquals(1L, member.getId(), "The ID should be set to 1L");

        // Boundary value: valid zero ID
        member.setId(0L);
        assertEquals(0L, member.getId(), "The ID should be set to 0L");

        // Boundary value: valid negative ID (if applicable)
        member.setId(-1L);
        assertEquals(-1L, member.getId(), "The ID should be set to -1L");
    }

    @Test
    public void testSetName() {
        Member member = new Member();

        // Equivalence class: valid name
        member.setName("Lukas");
        assertEquals("Lukas", member.getName(), "The name should be 'Lukas'");

        // Equivalence class: empty name
        member.setName("");
        assertEquals("", member.getName(), "The name should be an empty string");

        // Equivalence class: null name
        member.setName(null);
        assertNull(member.getName(), "The name should be null");
    }

    @Test
    public void testSetMembershipStatus() {
        Member member = new Member();

        // Equivalence class: valid status
        member.setMembershipStatus("active");
        assertEquals("active", member.getMembershipStatus(), "The status should be 'active'");

        // Equivalence class: empty status
        member.setMembershipStatus("");
        assertEquals("", member.getMembershipStatus(), "The status should be an empty string");

        // Equivalence class: null status
        member.setMembershipStatus(null);
        assertNull(member.getMembershipStatus(), "The status should be null");
    }

    @Test
    public void testSetHandicap() {
        Member member = new Member();

        // Boundary value: valid positive handicap
        member.setHandicap(1);
        assertEquals(1, member.getHandicap(), "The handicap should be set to 1L");

        // Boundary value: valid zero handicap
        member.setHandicap(0);
        assertEquals(0, member.getHandicap(), "The handicap should be set to 0L");

        // Boundary value: valid negative handicap (if applicable)
        member.setHandicap(-1);
        assertEquals(-1, member.getHandicap(), "The handicap should be set to -1L");
    }

}