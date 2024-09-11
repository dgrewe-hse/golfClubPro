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
package de.hse.golfclubmanagement.repositories;

import de.hse.golfclubmanagement.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Member entity.
 * Provides CRUD operations for Member and allows defining custom queries.
 * @author  Dennis Grewe
 * @since   0.1
 */
public interface MemberRepository extends JpaRepository<Member, Long> {

    /**
     * Finds a Member by their name.
     * 
     * @param name the name of the Member to find
     * @return the Member with the specified name, or null if none found
     */
    Member findByName(String name);
}
