package com.project.reap.Repository;

import com.project.reap.Entity.Star;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StarRepository extends JpaRepository<Star,Integer> {
    public List<Star> findAll();
    Star findByName(String starname);
}
