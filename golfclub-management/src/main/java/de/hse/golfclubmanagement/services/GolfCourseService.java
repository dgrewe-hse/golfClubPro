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

import de.hse.golfclubmanagement.models.GolfCourse;
import de.hse.golfclubmanagement.repositories.GolfCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing GolfCourse entities.
 * Provides business logic for GolfCourse operations and communicates with the repository.
 * @author  Dennis Grewe
 * @since   0.1
 */
@Service
public class GolfCourseService {

    @Autowired
    private GolfCourseRepository golfCourseRepository;

    /**
     * Saves a GolfCourse entity to the database.
     *
     * @param golfCourse the GolfCourse entity to save
     * @return the saved GolfCourse entity
     */
    public GolfCourse saveGolfCourse(GolfCourse golfCourse) {
        return golfCourseRepository.save(golfCourse);
    }

    /**
     * Retrieves all GolfCourse entities from the database.
     *
     * @return a list of all GolfCourse entities
     */
    public List<GolfCourse> getAllGolfCourses() {
        return golfCourseRepository.findAll();
    }

    /**
     * Finds a GolfCourse by its name.
     *
     * @param name the name of the GolfCourse to find
     * @return the GolfCourse with the specified name, or null if not found
     */
    public GolfCourse findByName(String name) {
        return golfCourseRepository.findByName(name);
    }
}
