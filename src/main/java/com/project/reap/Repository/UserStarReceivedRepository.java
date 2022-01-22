package com.project.reap.Repository;


import com.project.reap.Entity.User;
import com.project.reap.Entity.UserStarReceived;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserStarReceivedRepository extends JpaRepository<UserStarReceived,Integer> {

    UserStarReceived findByUser(User user);

  //  List<UserStarReceived> findFirst6ByOrderByGoldStarRecievedDesc();
}
