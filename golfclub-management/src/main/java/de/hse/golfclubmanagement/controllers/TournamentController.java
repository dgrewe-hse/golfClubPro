/** Copyright (c) 2024. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 3 only, as
 * published by the Free Software Foundation.  
 *
 * This code is distributed for educational purposes only, but WITHOUT
 * ANY WARRANTY; See the GNU General Public License version 3 for more 
 * details (a copy is included in the LICENSE file that
 * accompanied this code).
 */
package de.hse.golfclubmanagement.controllers;

import de.hse.golfclubmanagement.models.Tournament;
import de.hse.golfclubmanagement.services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date;

/**
 * REST controller for managing Tournament entities.
 * Provides endpoints for creating, retrieving, and querying tournaments.
 * @author  Dennis Grewe
 * @since   0.1
 */
@RestController
@RequestMapping("/api/v1/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    /**
     * Adds a new Tournament entity to the system.
     *
     * @param tournament the Tournament entity to be added
     * @return the added Tournament entity
     */
    @PostMapping
    public ResponseEntity<Tournament> addTournament(@RequestBody Tournament tournament) {
        if (tournament == null) {
            throw new IllegalArgumentException("Tournament must not be null");
        }
        if (tournament.getName() == null || tournament.getName().isEmpty()) {
            throw new IllegalArgumentException("Tournament name must not be empty");
        }
        if (tournament.getDate() == null) {
            throw new IllegalArgumentException("Tournament date must not be null");
        }
        if (tournament.getDate().before(new Date())) {
            throw new IllegalArgumentException("Tournament date must not be in the past");
        }
        Tournament savedTournament = tournamentService.addTournament(tournament);
        return ResponseEntity.ok(savedTournament);
    }

    /**
     * Retrieves a list of all Tournament entities.
     *
     * @return a list of all Tournament entities
     */
    @GetMapping
    public ResponseEntity<List<Tournament>> getAllTournaments() {
        List<Tournament> tournaments = tournamentService.getAllTournaments();
        return ResponseEntity.ok(tournaments);
    }

    /**
     * Finds a Tournament by its name.
     *
     * @param name the name of the Tournament to find
     * @return the Tournament entity if found, or a 404 response if not
     */
    @GetMapping("/findByName")
    public ResponseEntity<Tournament> findByName(@RequestParam String name) {
        Tournament tournament = tournamentService.findByName(name);
        return tournament != null ? ResponseEntity.ok(tournament) : ResponseEntity.notFound().build();
    }
}
