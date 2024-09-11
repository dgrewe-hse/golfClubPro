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
 *
 */
package de.hse.golfclubmanagement.models;

import javax.persistence.*;

/**
 * Represents a hole (Bahn) entity on a golf course (Golfplatz).
 * A Hole consists of its number, length, par, and a reference to the golf course it belongs to.
 * @author  Dennis Grewe
 * @since   0.1
 */
@Entity
public class Hole {

    /**
     * Unique identifier for each hole.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The number of the hole (Bahn), e.g., 1, 2, 3, etc.
     */
    private int number;

    /**
     * The length of the hole (Bahn) in meters.
     */
    private int length;

    /**
     * The par value of the hole, i.e., the number of strokes expected to complete the hole.
     */
    private int par;

    /**
     * The golf course (Golfplatz) to which this hole (Bahn) belongs.
     */
    @ManyToOne
    @JoinColumn(name = "golfcourse_id")
    private GolfCourse golfcourse;

    /**
     * Gets the unique identifier for this hole.
     * 
     * @return the id of the hole
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for this hole.
     * 
     * @param id the id to set for the hole
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the number of the hole (Bahn).
     * 
     * @return the number of the hole
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the number of the hole (Bahn).
     * 
     * @param number the number to set for the hole
     */
    public void setNummer(int number) {
        this.number = number;
    }

    /**
     * Gets the length of the hole (Bahn) in meters.
     * 
     * @return the length of the hole
     */
    public int getLength() {
        return this.length;
    }

    /**
     * Sets the length of the hole (Bahn) in meters.
     * 
     * @param length the length to set for the hole
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Gets the par value for this hole (Bahn).
     * 
     * @return the par value of the hole
     */
    public int getPar() {
        return par;
    }

    /**
     * Sets the par value for this hole (Bahn).
     * 
     * @param par the par value to set for the hole
     */
    public void setPar(int par) {
        this.par = par;
    }

    /**
     * Gets the golf course to which this hole belongs.
     * 
     * @return the golf course associated with this hole
     */
    public GolfCourse getGolfcourse() {
        return this.golfcourse;
    }

    /**
     * Sets the golf course to which this hole belongs.
     * 
     * @param golfcourse the golf course to associate with this Bahn
     */
    public void setGolfCourse(GolfCourse golfcourse) {
        this.golfcourse = golfcourse;
    }
}
