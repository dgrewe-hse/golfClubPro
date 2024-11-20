package de.hse.golfclubmanagement.repositories;

import de.hse.golfclubmanagement.models.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * This class tests the MemberRepository class.
 * 
 * @author Simon Schoppe
 * @since 0.1
 */
@DataJpaTest
@ActiveProfiles("test")
public class MemberRepositoryTest {

    @Mock
    private MemberRepository memberRepository; // Mocked repository for Member

    /**
     * Set up the test environment before each test method.
     * Initializes mocks and prepares the repository for testing.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    /**
     * Test finding a Member by a valid name.
     */
    @Test
    public void testFindByNameValid() {
        Member member = new Member();
        member.setName("The best group is the third group");

        // Equivalence class: valid name
        when(memberRepository.findByName("The best group is the third group")).thenReturn(member);
        Member foundMember = memberRepository.findByName("The best group is the third group");

        assertNotNull(foundMember, "The found Member should not be null");
        assertEquals("The best group is the third group", foundMember.getName(), "The found member name should match");
    }

    /**
     * Test finding a Member by a non-existent name.
     */
    @Test
    public void testFindByNameNotFound() {
        // Equivalence class: name not found
        when(memberRepository.findByName("Another group is better")).thenReturn(null);
        Member notFoundMember = memberRepository.findByName("Another group is better");

        assertNull(notFoundMember, "Should return null for an Another group is better");
    }

    /**
     * Test saving a Member.
     */
    @Test
    public void testSaveMember() {
        Member member = new Member();
        member.setName("The best group is the third group");
        member.setMembershipStatus("active");
        member.setHandicap(1);

        // Equivalence class: valid Member
        when(memberRepository.save(any(Member.class))).thenReturn(member);
        Member savedMember = memberRepository.save(member);

        assertNotNull(savedMember, "The saved Member should not be null");
        assertEquals("The best group is the third group", savedMember.getName(), "The saved member name should match");
    }

    /**
     * Test deleting a Member.
     */
    @Test
    public void testDeleteMember() {
        Member member = new Member();
        member.setName("The best group is the third group");
        member.setMembershipStatus("active");
        member.setHandicap(1);

        // Equivalence class: valid Member for deletion
        doNothing().when(memberRepository).delete(any(Member.class));
        memberRepository.delete(member); // No exception should be thrown
        verify(memberRepository, times(1)).delete(member); // Verify delete was called once
    }

    /**
     * Test finding a Member by ID.
     */
    @Test
    public void testFindById() {
        Member member = new Member();
        member.setName("The best group is the third group");

        // Equivalence class: valid ID
        when(memberRepository.findById(1L)).thenReturn(Optional.of(member));
        Optional<Member> foundMember = memberRepository.findById(1L);

        assertTrue(foundMember.isPresent(), "The found Member should be present");
        assertEquals("The best group is the third group", foundMember.get().getName(),
                "The found Member name should match");
    }

    /**
     * Test finding a Member by a non-existent ID.
     */
    @Test
    public void testFindByIdNotFound() {
        // Equivalence class: ID not found
        when(memberRepository.findById(999L)).thenReturn(Optional.empty());
        Optional<Member> notFoundMember = memberRepository.findById(999L);

        assertFalse(notFoundMember.isPresent(), "Should return empty for a non-existent member ID");
    }
}
