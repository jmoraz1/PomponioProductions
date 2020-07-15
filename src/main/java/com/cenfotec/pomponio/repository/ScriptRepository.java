package com.cenfotec.pomponio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cenfotec.pomponio.domain.Script;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScriptRepository extends JpaRepository<Script,
        Long> {

    @Query("SELECT s FROM Script s WHERE s.genre = ?1")
    public List<Script> findByGenre(@Param("genre") String genre);

    @Query("SELECT s FROM Script s WHERE s.name like %:name%")
    public List<Script> findByName(@Param("name") String name);
} 