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

import de.hse.golfclubmanagement.models.GolfCourse;
import de.hse.golfclubmanagement.services.GolfCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing GolfCourse entities.
 * Provides endpoints for creating, retrieving, and querying golf courses.
 * @author  Dennis Grewe
 * @since   0.1
 */
@RestController
@RequestMapping("/api/v1/golfcourses")
public class GolfCourseController {

    @Autowired
    private GolfCourseService golfCourseService;

    /**
     * Adds a new GolfCourse entity to the system.
     *
     * @param golfCourse the GolfCourse entity to be added
     * @return the added GolfCourse entity
     */
    @PostMapping
    public ResponseEntity<GolfCourse> addGolfCourse(@RequestBody GolfCourse golfCourse) {
        GolfCourse savedGolfCourse = golfCourseService.saveGolfCourse(golfCourse);
        return ResponseEntity.ok(savedGolfCourse);
    }

    /**
     * Retrieves a list of all GolfCourse entities.
     *
     * @return a list of all GolfCourse entities
     */
    @GetMapping
    public ResponseEntity<List<GolfCourse>> getAllGolfCourses() {
        List<GolfCourse> golfCourses = golfCourseService.getAllGolfCourses();
        return ResponseEntity.ok(golfCourses);
    }

    /**
     * Finds a GolfCourse by its name.
     *
     * @param name the name of the GolfCourse to find
     * @return the GolfCourse entity if found, or a 404 response if not
     */
    @GetMapping("/findByName")
    public ResponseEntity<GolfCourse> findByName(@RequestParam String name) {
        GolfCourse golfCourse = golfCourseService.findByName(name);
        return golfCourse != null ? ResponseEntity.ok(golfCourse) : ResponseEntity.notFound().build();
    }
}
