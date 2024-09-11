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
import java.util.Date;

/**
 * Represents a tournament (Tournament) in the golf club.
 * A Tournament has a name, date, and possibly other related attributes.
 * @author  Dennis Grewe
 * @since   0.1
 */
@Entity
public class Tournament {

    /**
     * Unique identifier for each Tournament.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the tournament.
     */
    private String name;

    /**
     * The date on which the tournament takes place.
     */
    @Temporal(TemporalType.DATE)
    private Date date;

    /**
     * Gets the unique identifier for this Tournament.
     * 
     * @return the id of the Tournament
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for this Tournament.
     * 
     * @param id the id to set for the Tournament
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the Tournament.
     * 
     * @return the name of the Tournament
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Tournament.
     * 
     * @param name the name to set for the Tournament
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the date of the Tournament.
     * 
     * @return the date of the Tournament
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the Tournament.
     * 
     * @param date the date to set for the Tournament
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
