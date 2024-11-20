package de.hse.golfclubmanagement.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import de.hse.golfclubmanagement.models.Member;
import de.hse.golfclubmanagement.services.MemberService;

public class MemberControllerTest {
    @Mock
    private MemberService memberService; // Mocked service for Member

    @InjectMocks
    private MemberController memberController; // Controller instance with mocked service injected

    /**
     * Set up the test environment before each test method.
     * Initializes mocks and prepares the controller for testing.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    /**
     * Test adding a valid Member.
     */
    @Test
    public void testAddValidMember() {
        Member member = new Member();
        member.setName("Lukas");
        member.setMembershipStatus("active");
        member.setHandicap(1);

        // Equivalence class: valid Member
        when(memberService.addMember(any(Member.class))).thenReturn(member);
        ResponseEntity<Member> response = memberController.addMember(member);

        assertEquals(200, response.getStatusCodeValue(), "Response should have status 200 OK");
        assertEquals(member, response.getBody(), "The returned Member should match the saved one");
    }

    /**
     * Test adding a null Member.
     */
    @Test
    public void testAddNullMember() {
        // Equivalence class: null Member
        when(memberService.addMember(any(Member.class))).thenReturn(null);
        ResponseEntity<Member> response = memberController.addMember(null);

        assertEquals(200, response.getStatusCodeValue(), "Response should have status 200 OK");
        assertNull(response.getBody(), "The returned Member should be null");
    }

    /**
     * Test retrieving all Member entities.
     */
    @Test
    public void testGetAllMembers() {
        List<Member> members = new ArrayList<>();
        members.add(new Member());
        members.add(new Member());

        // Equivalence class: retrieving all members
        when(memberService.getAllMembers()).thenReturn(members);
        ResponseEntity<List<Member>> response = memberController.getAllMembers();

        assertEquals(200, response.getStatusCodeValue(), "Response should have status 200 OK");
        assertNotNull(response.getBody(), "Response body should not be null");
        assertEquals(2, response.getBody().size(), "Should return a list of 2 Members");
    }

    /**
     * Test finding a Member by a valid name.
     */
    @Test
    public void testFindByNameValid() {
        Member member = new Member();
        member.setName("Lukas");

        // Equivalence class: valid name
        when(memberService.findByName("Lukas")).thenReturn(member);
        ResponseEntity<Member> response = memberController.findByName("Lukas");

        assertEquals(200, response.getStatusCodeValue(), "Response should have status 200 OK");
        assertEquals(member, response.getBody(), "The found Member should match the requested name");
    }

    /**
     * Test finding a Member by a non-existent name.
     */
    @Test
    public void testFindByNameNotFound() {
        // Equivalence class: name not found
        when(memberService.findByName("Non-existent Member")).thenReturn(null);
        ResponseEntity<Member> response = memberController.findByName("Non-existent Member");

        assertEquals(404, response.getStatusCodeValue(), "Response should have status 404 Not Found");
        assertNull(response.getBody(), "The response body should be null for a non-existent member");
    }
}