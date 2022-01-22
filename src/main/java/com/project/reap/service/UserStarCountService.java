package com.project.reap.service;

import com.project.reap.Entity.User;
import com.project.reap.Entity.UserStarCount;
import com.project.reap.Repository.UserStarCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserStarCountService {

    @Autowired
    UserStarCountRepository userStarCountRepository;


    public UserStarCount findByUser(User user) {

        return userStarCountRepository.findByUser(user);
    }

    public void saveStars(UserStarCount userStarCount) {

        userStarCountRepository.save(userStarCount);

    }

    public void update(User user, String star) {

        UserStarCount userStarCount = userStarCountRepository.findByUser(user);


        System.out.println(userStarCount);
        if (star.equals("Gold")) {
            userStarCount.setGoldStarCount(userStarCount.getGoldStarCount() - 1);

        } else if (star.equals("Silver")) {

            userStarCount.setSilverStarCount(userStarCount.getSilverStarCount() - 1);
        } else if (star.equals("Bronze")) {

            userStarCount.setBronzeStarCount(userStarCount.getBronzeStarCount() - 1);
        }



        userStarCountRepository.save(userStarCount);

    }
}