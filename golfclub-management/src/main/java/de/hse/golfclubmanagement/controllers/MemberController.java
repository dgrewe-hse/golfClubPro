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

import de.hse.golfclubmanagement.models.Member;
import de.hse.golfclubmanagement.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Member entities.
 * Provides endpoints for creating, retrieving, and querying members.
 * @author  Dennis Grewe
 * @since   0.1
 */
@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * Adds a new Member entity to the system.
     *
     * @param member the Member entity to be added
     * @return the added Member entity
     */
    @PostMapping
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        Member savedMember = memberService.addMember(member);
        return ResponseEntity.ok(savedMember);
    }

    /**
     * Retrieves a list of all Member entities.
     *
     * @return a list of all Member entities
     */
    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    /**
     * Finds a Member by their name.
     *
     * @param name the name of the Member to find
     * @return the Member entity if found, or a 404 response if not
     */
    @GetMapping("/findByName")
    public ResponseEntity<Member> findByName(@RequestParam String name) {
        Member member = memberService.findByName(name);
        return member != null ? ResponseEntity.ok(member) : ResponseEntity.notFound().build();
    }
}
