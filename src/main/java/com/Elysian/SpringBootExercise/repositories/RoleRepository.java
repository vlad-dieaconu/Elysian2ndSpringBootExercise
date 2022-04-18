package com.Elysian.SpringBootExercise.repositories;

import com.Elysian.SpringBootExercise.model.ERole;
import com.Elysian.SpringBootExercise.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
