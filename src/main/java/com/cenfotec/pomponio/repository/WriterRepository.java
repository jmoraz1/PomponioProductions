package com.cenfotec.pomponio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cenfotec.pomponio.domain.Writer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WriterRepository extends JpaRepository<Writer,
        Long> {
    @Query("SELECT w FROM Writer w WHERE w.id = ?1")
    public <T> T  findByID(@Param("id") Long id);
}