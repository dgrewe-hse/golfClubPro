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
package de.hse.golfclubmanagement.services;

import de.hse.golfclubmanagement.models.Tournament;
import de.hse.golfclubmanagement.repositories.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing Tournament entities.
 * Provides business logic for Tournament operations and communicates with the repository.
 * @author  Dennis Grewe
 * @since   0.1
 */
@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    /**
     * Adds a new Tournament entity to the database.
     *
     * @param tournament the Tournament entity to add
     * @return the saved Tournament entity
     */
    public Tournament addTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    /**
     * Retrieves all Tournament entities from the database.
     *
     * @return a list of all Tournament entities
     */
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    /**
     * Finds a Tournament by its name.
     *
     * @param name the name of the Tournament to find
     * @return the Tournament with the specified name, or null if not found
     */
    public Tournament findByName(String name) {
        return tournamentRepository.findByName(name);
    }
}
