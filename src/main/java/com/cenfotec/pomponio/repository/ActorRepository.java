package com.cenfotec.pomponio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cenfotec.pomponio.domain.Actor;

public interface ActorRepository extends JpaRepository<Actor,
        Long> {
}