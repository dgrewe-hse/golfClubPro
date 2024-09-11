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

import de.hse.golfclubmanagement.models.Member;
import de.hse.golfclubmanagement.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing Member entities.
 * Provides business logic for Member operations and communicates with the repository.
 * @author  Dennis Grewe
 * @since   0.1
 */
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    /**
     * Adds a new Member entity to the database.
     *
     * @param member the Member entity to add
     * @return the saved Member entity
     */
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    /**
     * Retrieves all Member entities from the database.
     *
     * @return a list of all Member entities
     */
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    /**
     * Finds a Member by their name.
     *
     * @param name the name of the Member to find
     * @return the Member with the specified name, or null if not found
     */
    public Member findByName(String name) {
        return memberRepository.findByName(name);
    }
}
