package com.cenfotec.pomponio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cenfotec.pomponio.domain.Writer;

public interface WriterRepository extends JpaRepository<Writer,
        Long> {
} 