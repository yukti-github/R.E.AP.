package com.project.reap.service;

import com.project.reap.Entity.User;
import com.project.reap.Entity.UserStarReceived;
import com.project.reap.Repository.UserStarReceivedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStarReceivedService {

    @Autowired
    UserStarReceivedRepository userStarRecievedRepository;

    public void giveStar(User user, String star)
    {
        UserStarReceived userStarReceived =   userStarRecievedRepository.findByUser(user);

        if(star.equals("Gold"))
        {
            userStarReceived.setGoldStarRecieved(userStarReceived.getGoldStarRecieved()+1);
        }
        else if(star.equals("Silver")){

            userStarReceived.setSilverStarRecieved(userStarReceived.getSilverStarRecieved()+1);

        }

        else if(star.equals("Bronze")){
            userStarReceived.setBronzeStarRecieved(userStarReceived.getBronzeStarRecieved()+1);

        }
        Integer points= userStarReceived.getBronzeStarRecieved()*10+
                userStarReceived.getSilverStarRecieved()*20+
                userStarReceived.getGoldStarRecieved()*30;
        user.setPoints(points);
        System.out.println("this user has points="+user.getPoints());
        System.out.println(userStarReceived);

        userStarRecievedRepository.save(userStarReceived);


    }
    public void save(UserStarReceived userStarReceived){
        userStarRecievedRepository.save(userStarReceived);
    }

    public UserStarReceived findByUser(User user)
    {
        return userStarRecievedRepository.findByUser(user);
    }



//    public List<UserStarReceived> getSomeUser(){
//
//        return userStarRecievedRepository.findFirst6ByOrderByGoldStarRecievedDesc();
//    }
}
