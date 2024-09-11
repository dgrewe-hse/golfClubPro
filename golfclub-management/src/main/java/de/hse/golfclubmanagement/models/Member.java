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

/**
 * Represents a member (Member) of the golf club.
 * A Member has a name, membership status, and a handicap that indicates the player's skill level.
 * @author  Dennis Grewe
 * @since   0.1
 */
@Entity
public class Member {

    /**
     * Unique identifier for each Member.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the member.
     */
    private String name;

    /**
     * The membership status of the member (e.g., active, inactive).
     */
    private String membershipStatus;

    /**
     * The handicap of the member, which indicates the player's skill level.
     */
    private int handicap;

    // ####################
    // Getters and setters

    /**
     * Gets the unique identifier for this Member.
     * 
     * @return the id of the Member
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the unique identifier for this Member.
     * 
     * @param id the id to set for the Member
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the Member.
     * 
     * @return the name of the Member
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the Member.
     * 
     * @param name the name to set for the Member
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the membership status of the Member.
     * 
     * @return the membership status of the Member
     */
    public String getMembershipStatus() {
        return membershipStatus;
    }

    /**
     * Sets the membership status of the Member.
     * 
     * @param membershipStatus the membership status to set for the Member
     */
    public void setMembershipStatus(String membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    /**
     * Gets the handicap of the Member.
     * 
     * @return the handicap of the Member
     */
    public int getHandicap() {
        return this.handicap;
    }

    /**
     * Sets the handicap of the Member.
     * 
     * @param handicap the handicap to set for the Member
     */
    public void setHandicap(int handicap) {
        this.handicap = handicap;
    }
}
