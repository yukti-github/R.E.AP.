package com.project.reap.controller;

import com.project.reap.Entity.User;
import com.project.reap.Entity.UserStarReceived;
import com.project.reap.Repository.UserStarReceivedRepository;
import com.project.reap.service.UserService;
import com.project.reap.service.UserStarReceivedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class CalculatePoints {
        @Autowired
        HttpSession httpSession;

        @Autowired
    UserStarReceivedRepository userStarReceivedRepository;

        @PostMapping("/calculatePoints")
        public int calculatePoints()
        {
            User user=(User)httpSession.getAttribute("user");
            UserStarReceived userStarReceived =   userStarReceivedRepository.findByUser(user);
            Integer pts=( userStarReceived.getGoldStarRecieved()*30)+
                    (userStarReceived.getSilverStarRecieved()*20)
                    +(userStarReceived.getBronzeStarRecieved()*10);
            user.setPoints(pts);
            return pts;
        }


    }

