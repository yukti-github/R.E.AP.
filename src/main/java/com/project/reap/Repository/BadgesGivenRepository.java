package com.project.reap.Repository;

import com.project.reap.Entity.BadgesGiven;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BadgesGivenRepository extends JpaRepository<BadgesGiven,Integer> {

    List<BadgesGiven> findAllByOrderByIdDesc();
    @Override
    <S extends BadgesGiven> S save(S entity);
}
