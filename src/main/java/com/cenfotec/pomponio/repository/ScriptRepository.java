package com.cenfotec.pomponio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cenfotec.pomponio.domain.Script;

public interface ScriptRepository extends JpaRepository<Script,
        Long> {
} 