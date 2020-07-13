package com.cenfotec.pomponio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cenfotec.pomponio.domain.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor,
        Long> {
    @Query("SELECT a FROM Actor a WHERE a.gender = gender")
    public List<Actor> findByGender(@Param("gender") String gender);

    @Query("SELECT a FROM Actor a WHERE a.name like %:name%")
    public List<Actor> findByName(@Param("name") String name);

}
