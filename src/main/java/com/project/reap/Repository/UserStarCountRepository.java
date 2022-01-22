package com.project.reap.Repository;

import com.project.reap.Entity.User;
import com.project.reap.Entity.UserStarCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStarCountRepository extends JpaRepository<UserStarCount,Integer> {

    UserStarCount findByUser(User user);
    @Override
   <S extends UserStarCount> S save(S entity);
}
