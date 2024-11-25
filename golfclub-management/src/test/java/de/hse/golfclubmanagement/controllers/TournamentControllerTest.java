package de.hse.golfclubmanagement.controllers;

import de.hse.golfclubmanagement.models.Tournament;
import de.hse.golfclubmanagement.services.TournamentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Noah Scholz
 * @since 0.1
 */
public class TournamentControllerTest {

    @Mock
    private TournamentService tournamentService;

    @InjectMocks
    private TournamentController tournamentController;

    private Tournament validTournament;
    private static final String VALID_NAME = "Summer Championship";
    private static final LocalDate VALID_LOCAL_DATE = LocalDate.now().plusDays(30);

    /**
     * Helper method to convert LocalDate to Date
     */
    private Date convertToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        
        // Setup valid tournament for reuse in tests
        validTournament = new Tournament();
        validTournament.setName(VALID_NAME);
        validTournament.setDate(convertToDate(VALID_LOCAL_DATE));
    }
    /**
     * Test adding a valid Tournament with all required fields.
     * Equivalence class: Valid input
     */
    @Test
    public void testAddValidTournament() {
        when(tournamentService.addTournament(any(Tournament.class))).thenReturn(validTournament);
        
        ResponseEntity<Tournament> response = tournamentController.addTournament(validTournament);

        assertEquals(200, response.getStatusCodeValue(), "Response should have status 200 OK");
        assertEquals(validTournament, response.getBody(), "The returned Tournament should match the saved one");
        verify(tournamentService).addTournament(any(Tournament.class));
    }

    /**
     * Test adding a null Tournament.
     * Equivalence class: Invalid input - null
     */
    @Test
    public void testAddNullTournament() {

        when(tournamentService.addTournament(null)).thenReturn(null); // Should not reach this point

        assertThrows(IllegalArgumentException.class, 
            () -> tournamentController.addTournament(null),
            "Should throw IllegalArgumentException for null Tournament");

        verify(tournamentService, never()).addTournament(null);
    }

    /**
     * Test adding a Tournament with missing required fields.
     * Equivalence class: Invalid input - incomplete data
     */
    @Test
    public void testAddTournamentMissingRequiredFields() {
        Tournament incompleteTournament = new Tournament();

        when(tournamentService.addTournament(incompleteTournament)).thenReturn(null); // Should not reach this point

        assertThrows(IllegalArgumentException.class,
            () -> tournamentController.addTournament(incompleteTournament),
            "Should throw IllegalArgumentException for incomplete Tournament");

        verify(tournamentService, never()).addTournament(incompleteTournament);
    }
    /**
     * Test Tournament with empty name.
     * Boundary value: Minimum name length
     */
    @Test
    public void testAddTournamentEmptyName() {
        Tournament tournamentEmptyName = new Tournament();
        tournamentEmptyName.setName("");
        tournamentEmptyName.setDate(convertToDate(VALID_LOCAL_DATE));

        when(tournamentService.addTournament(tournamentEmptyName)).thenReturn(null); // Should not reach this point

        assertThrows(IllegalArgumentException.class,
            () -> tournamentController.addTournament(tournamentEmptyName),
            "Should throw IllegalArgumentException for empty name");

        verify(tournamentService, never()).addTournament(tournamentEmptyName);
    }

    /**
     * Test Tournament with past date.
     * Boundary value: Date validation
     */
    @Test
    public void testAddTournamentPastDate() {
        Tournament tournamentPastDate = new Tournament();
        tournamentPastDate.setName(VALID_NAME);
        tournamentPastDate.setDate(convertToDate(LocalDate.now().minusDays(1)));

        when(tournamentService.addTournament(tournamentPastDate)).thenReturn(null); // Should not reach this point

        assertThrows(IllegalArgumentException.class,
            () -> tournamentController.addTournament(tournamentPastDate),
            "Should throw IllegalArgumentException for past date");

        verify(tournamentService, never()).addTournament(tournamentPastDate);
    }

    /**
     * Test finding Tournament with existing name.
     * Decision table: Exists=Y, ValidName=Y
     */
    @Test
    public void testFindByNameValid() {
        when(tournamentService.findByName(VALID_NAME)).thenReturn(validTournament);
        
        ResponseEntity<Tournament> response = tournamentController.findByName(VALID_NAME);
        
        assertEquals(200, response.getStatusCodeValue(), "Response should have status 200 OK");
        assertEquals(validTournament, response.getBody(), "Should return matching tournament");
    }

    /**
     * Test finding Tournament with non-existent name.
     * Decision table: Exists=N, ValidName=Y
     */
    @Test
    public void testFindByNameNotFound() {
        when(tournamentService.findByName("Non-existent")).thenReturn(null);
        
        ResponseEntity<Tournament> response = tournamentController.findByName("Non-existent");
        
        assertEquals(404, response.getStatusCodeValue(), "Response should have status 404 Not Found");
        assertNull(response.getBody(), "Body should be null for non-existent tournament");
    }

    /**
     * Test getting all Tournaments when list is empty.
     * Decision table: Exists=N
     */
    @Test
    public void testGetAllTournamentsEmpty() {
        when(tournamentService.getAllTournaments()).thenReturn(new ArrayList<>());
        
        ResponseEntity<List<Tournament>> response = tournamentController.getAllTournaments();
        
        assertEquals(200, response.getStatusCodeValue(), "Response should have status 200 OK");
        assertTrue(response.getBody().isEmpty(), "Should return empty list");
    }

    /**
     * Test getting all Tournaments with multiple entries.
     * Decision table: Exists=Y
     */
    @Test
    public void testGetAllTournamentsMultiple() {
        List<Tournament> tournaments = new ArrayList<>();
        tournaments.add(validTournament);
        Tournament secondTournament = new Tournament();
        secondTournament.setName("Winter Cup");
        secondTournament.setDate(convertToDate(VALID_LOCAL_DATE.plusMonths(6)));
        tournaments.add(secondTournament);

        when(tournamentService.getAllTournaments()).thenReturn(tournaments);
        
        ResponseEntity<List<Tournament>> response = tournamentController.getAllTournaments();
        
        assertEquals(200, response.getStatusCodeValue(), "Response should have status 200 OK");
        assertEquals(2, response.getBody().size(), "Should return list with 2 tournaments");
    }
}