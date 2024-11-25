package de.hse.golfclubmanagement.services;

import de.hse.golfclubmanagement.models.Tournament;
import de.hse.golfclubmanagement.repositories.TournamentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TournamentServiceTest {

    @Mock
    private TournamentRepository tournamentRepository;

    @InjectMocks
    private TournamentService tournamentService;

    /**
     * Set up the test environment before each test method.
     * Initializes mocks and prepares the service for testing.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test adding a valid Tournament.
     */
    @Test
    public void testAddValidTournament() {
        Tournament tournament = new Tournament();
        tournament.setName("Spring Championship");

        when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament);
        Tournament savedTournament = tournamentService.addTournament(tournament);
        assertEquals("Spring Championship", savedTournament.getName(), "The saved tournament name should match");
    }

    /**
     * Test adding a null Tournament.
     */
    @Test
    public void testAddNullTournament() {
        when(tournamentRepository.save(null)).thenThrow(new IllegalArgumentException("Tournament cannot be null"));
        assertThrows(IllegalArgumentException.class, () -> tournamentService.addTournament(null), "Should throw IllegalArgumentException for null Tournament");
    }

    @Test
    public void testAddTournamentWithBlankName() {
        Tournament tournament = new Tournament();
        tournament.setName(" ");
        assertThrows(IllegalArgumentException.class, () -> tournamentService.addTournament(tournament),
                "Should throw IllegalArgumentException for blank name");
    }

    /**
     * Test retrieving all Tournament entities.
     */
    @Test
    public void testGetAllTournaments() {
        List<Tournament> tournaments = new ArrayList<>();
        tournaments.add(new Tournament());
        tournaments.add(new Tournament());

        // Equivalence class: retrieving all tournaments
        when(tournamentRepository.findAll()).thenReturn(tournaments);
        List<Tournament> result = tournamentService.getAllTournaments();
        assertEquals(2, result.size(), "Should return a list of 2 Tournaments");
        verify(tournamentRepository, times(1)).findAll();
    }

    /**
     * Test finding a Tournament by a valid name.
     */
    @Test
    public void testFindByNameValid() {
        Tournament tournament = new Tournament();
        tournament.setName("Spring Championship");

        when(tournamentRepository.findByName("Spring Championship")).thenReturn(tournament);
        Tournament foundTournament = tournamentService.findByName("Spring Championship");
        assertEquals("Spring Championship", foundTournament.getName(), "The found tournament name should match");
    }

    /**
     * Test finding a Tournament by a non-existent name.
     */
    @Test
    public void testFindByNameNotFound() {
        when(tournamentRepository.findByName("Non-existent Tournament")).thenReturn(null);
        Tournament notFoundTournament = tournamentService.findByName("Non-existent Tournament");
        assertNull(notFoundTournament, "Should return null for a non-existent tournament");
    }

    /**
     * Test finding a Tournament by an empty or null name.
     */
    @Test
    public void testFindByNameWithNullOrBlankName() {
        // Überprüfe, ob die korrekte Exception mit der richtigen Nachricht geworfen wird
        IllegalArgumentException exceptionNull = assertThrows(IllegalArgumentException.class, () -> tournamentService.findByName(null));
        assertEquals("Name cannot be null or blank", exceptionNull.getMessage(), "Exception message should match expected");

        IllegalArgumentException exceptionBlank = assertThrows(IllegalArgumentException.class, () -> tournamentService.findByName(" "));
        assertEquals("Name cannot be null or blank", exceptionBlank.getMessage(), "Exception message should match expected");
    }
}
