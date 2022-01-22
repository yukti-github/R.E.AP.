package com.project.reap.Repository;

import com.project.reap.Entity.Karma;
import com.project.reap.Entity.Star;
import com.project.reap.Entity.User;
import com.project.reap.Entity.UserStarCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface KarmaRepository extends JpaRepository<Karma,Integer> {

    @Query("Select e from Karma e where karmaName=:karmaName")
    Optional<Karma> findByName(@Param("karmaName")String name);

    @Override
    <S extends Karma> S save(S entity);
}