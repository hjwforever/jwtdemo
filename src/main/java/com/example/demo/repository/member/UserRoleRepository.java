package com.example.demo.repository.member;


import com.example.demo.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author hjwforever
 * @date 12/03/2021 6:53 PM
 */

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
	UserRole findByRolename(String name);
}
