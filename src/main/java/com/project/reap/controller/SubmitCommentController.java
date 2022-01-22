package com.project.reap.controller;

import com.project.reap.Entity.BadgesGiven;
import com.project.reap.Entity.Karma;
import com.project.reap.Entity.User;
import com.project.reap.Repository.KarmaRepository;
import com.project.reap.Repository.StarRepository;
import com.project.reap.service.BadgesGivenService;
import com.project.reap.service.UserService;
import com.project.reap.service.UserStarCountService;
import com.project.reap.service.UserStarReceivedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Optional;

@RestController
public class SubmitCommentController {


    @Autowired
    UserService userService;

    @Autowired
    BadgesGivenService badgesGivenService;

    @Autowired
    StarRepository starRepository;

    @Autowired
    UserStarCountService userStarCountService;

    @Autowired
    UserStarReceivedService userStarRecievedService;

    @Autowired
    HttpSession httpSession;

    @Autowired
    KarmaRepository karmaRepository;


    @PostMapping(value = "/submitComment")
    int submitComment(@RequestParam Map<String, String> fields) {

        //System.out.println(fields);


        // Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user1 = (User) httpSession.getAttribute("user");
        String mail = user1.getEmail();
        User userGiver = userService.findByMailUser(mail);
        //  User userGiver = userService.findByEmail(((UserDetails)principal).getUsername());
        User userReciever = userService.findByMailUser(fields.get("email"));
        BadgesGiven badgesGiven = new BadgesGiven();
          badgesGiven.setGiver(userGiver);
            badgesGiven.setReceiver(userReciever);

            badgesGiven.setComment(fields.get("reason"));
            Optional<Karma> karmaOptional=karmaRepository.findByName(fields.get("karma"));
            if(karmaOptional.isPresent())
            {badgesGiven.setKarma(karmaOptional.get());}
            else
            {
                badgesGiven.setKarma(new Karma(3,"yukti"));
            }

            badgesGiven.setStar(starRepository.findByName(fields.get("badge")));
            badgesGiven.setFlag(true);

     //   if ((badgesGiven.getComment() != null) && (badgesGiven.getGiver() != null) && (badgesGiven.getReceiver() != null) && (badgesGiven.getStar() != null)) {
            badgesGivenService.save(badgesGiven);

            //reducing stars from sender
            userStarCountService.update(userGiver, fields.get("badge"));

            //Giving star to reciever

            userStarRecievedService.giveStar(userReciever, fields.get("badge"));

            return 1;
       // } else return 0;
    }
}