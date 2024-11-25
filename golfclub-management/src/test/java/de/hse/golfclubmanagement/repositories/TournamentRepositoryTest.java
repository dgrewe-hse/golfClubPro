package de.hse.golfclubmanagement.repositories;

import de.hse.golfclubmanagement.models.Tournament;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TournamentRepositoryMockTest {

    @Mock
    private TournamentRepository tournamentRepository;

    private Tournament sampleTournament;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        sampleTournament = new Tournament();
        sampleTournament.setName("Spring Invitational");
        sampleTournament.setDate(new java.util.Date()); // Set a valid date
    }

    @Test
    void testSaveTournament() {
        // Mock behavior for saving a tournament
        when(tournamentRepository.save(sampleTournament)).thenReturn(sampleTournament);

        Tournament savedTournament = tournamentRepository.save(sampleTournament);

        assertNotNull(savedTournament, "Saved tournament should not be null");
        assertEquals("Spring Invitational", savedTournament.getName(), "Tournament name should match");
    }

    @Test
    void testFindByNameValid() {
        // Mock behavior for finding a tournament by name
        when(tournamentRepository.findByName("Spring Invitational")).thenReturn(sampleTournament);

        Tournament foundTournament = tournamentRepository.findByName("Spring Invitational");

        assertNotNull(foundTournament, "Should find a tournament with the given name");
        assertEquals("Spring Invitational", foundTournament.getName(), "The found tournament name should match");
    }

    @Test
    void testFindByNameNotFound() {
        // Mock behavior for finding a non-existent tournament
        when(tournamentRepository.findByName("Non-existent Tournament")).thenReturn(null);

        Tournament foundTournament = tournamentRepository.findByName("Non-existent Tournament");

        assertNull(foundTournament, "Should return null for a non-existent tournament name");
    }

    @Test
    void testFindByIdValid() {
        // Mock behavior for finding a tournament by ID
        when(tournamentRepository.findById(1L)).thenReturn(Optional.of(sampleTournament));

        Optional<Tournament> foundTournament = tournamentRepository.findById(1L);

        assertTrue(foundTournament.isPresent(), "Should find a tournament with the given ID");
        assertEquals("Spring Invitational", foundTournament.get().getName(), "The found tournament name should match");
    }

    @Test
    void testFindByIdNotFound() {
        // Mock behavior for a non-existent ID
        when(tournamentRepository.findById(999L)).thenReturn(Optional.empty());

        Optional<Tournament> foundTournament = tournamentRepository.findById(999L);

        assertFalse(foundTournament.isPresent(), "Should return empty for a non-existent ID");
    }

    @Test
    void testDeleteTournament() {
        // Mock behavior for deleting a tournament
        doNothing().when(tournamentRepository).delete(sampleTournament);

        tournamentRepository.delete(sampleTournament);

        verify(tournamentRepository, times(1)).delete(sampleTournament);
    }
}
