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
package de.hse.golfclubmanagement.models;

import javax.persistence.*;
import java.util.List;

/**
 * This class represents a DAO model for storing golf courts
 * in a data base including a list of lanes.
 * @author  Dennis Grewe
 * @since   0.1
 */
@Entity
public class GolfCourse {

    /**
     * Unique identifier for each golf course.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the golf course
     */
    private String name;

    /**
     * The location (Ort) of the golf course.
     */
    private String location;

     /**
     * The list of holes (Bahnen) associated with this Golfplatz.
     * Each hole is an instance of the Hole class.
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "golfcourse")
    private List<Hole> holes;

    // ####################
    // Getters and setters

   /**
     * Gets the unique identifier for this golf course.
     * 
     * @return the id of the golf course
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for this golf course.
     * 
     * @param id the id to set for the golf course
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the golf course.
     * 
     * @return the name of the golf course
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the golf course.
     * 
     * @param name the name to set for the golf course
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the location (Ort) of the golf course.
     * 
     * @return the location of the golf course
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Sets the location (Ort) of the golf course.
     * 
     * @param ort the location to set for the golf course
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the list of holes (Bahnen) associated with this golf course.
     * 
     * @return the list of holes
     */
    public List<Hole> getHoles() {
        return this.holes;
    }

    /**
     * Sets the list of holes (Bahnen) associated with this golf course.
     * 
     * @param holes the list of holes to set for the golf course
     */
    public void setHoles(List<Hole> holes) {
        this.holes = holes;
    }
}
