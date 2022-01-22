package com.project.reap.controller;


import com.project.reap.Entity.*;
//import com.project.reap.Events.KarmaBootstrap;
import com.project.reap.Events.StarBootstrap;
import com.project.reap.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    UserStarCountService userStarCountService;
    @Autowired
    HttpSession session;
    @Autowired
    BadgesGivenService badgesGivenService;
    @Autowired
    StarService starService;
    @Autowired
    KarmaService karmaService;
    //@Autowired
   // KarmaBootstrap karmaBootstrap;
    @Autowired
    StarBootstrap starBootstrap;

    @Autowired
    UserRoleService userRoleService;

    @Autowired
    UserStarReceivedService userStarReceivedService;

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute(new User());
        return "register";
    }


    @RequestMapping(value = "/registered", method = RequestMethod.POST)
    public String register2(@ModelAttribute User newUser)
    {
        //session.setAttribute("user",user1);
        //User user= (User)session.getAttribute("user");

        newUser.setActive(true);
        Set<UserRole> roles = new HashSet<>();
        roles.add(userRoleService.getRole(1));
        newUser.setRoles(roles);
        // Save user
        User user = userService.saveUser(newUser);


        //assigning default stars

        UserStarCount userStarCount = new UserStarCount();


        userStarCount.setUser(user);

        userStarCount.setGoldStarCount(userRoleService.getRole(1).getGoldStar());
        userStarCount.setSilverStarCount(userRoleService.getRole(1).getSilverStar());
        userStarCount.setBronzeStarCount(userRoleService.getRole(1).getBronzeStar());


        userStarCountService.saveStars(userStarCount);

        // adding in user star recieved table
        UserStarReceived userStarReceived = new UserStarReceived();
        userStarReceived.setUser(newUser);
        userStarReceived.setGoldStarRecieved(new Integer(0));
        userStarReceived.setBronzeStarRecieved(new Integer(0));
        userStarReceived.setSilverStarRecieved(new Integer(0));

        userStarReceivedService.save(userStarReceived);

        return "successful-register";
    }


    @RequestMapping("/login")
    public String login() {

        return "login";
    }

    @RequestMapping(value = "/logindata", method = RequestMethod.POST)
    public ModelAndView validate(@RequestParam("uid") String username, @RequestParam("pswd") String password, Model model) {

        starBootstrap.initStar();
        User user = userService.checkForLogin(username, password);
        session.setAttribute("user",user);
        if (user != null && user.isActive()==true) {
            User user1= (User)session.getAttribute("user");
            ModelAndView modelAndView = new ModelAndView("Dashboard");
            modelAndView.addObject("image", "/images/" + user1.getUserName() + ".jpeg");
            UserStarCount userStarCount = userStarCountService.findByUser(user1);
            modelAndView.addObject("userStarCount",userStarCount);
         //  karmaBootstrap.init();


            List<BadgesGiven> post = badgesGivenService.getPosts();
            modelAndView.addObject("post",post);
            System.out.println("posts are "+post);


            UserStarReceived userStarReceived = userStarReceivedService.findByUser(user);
                 modelAndView.addObject("starRecieved", userStarReceived);
//
//            user1.setPoints(point);

            List<Karma> karmaList =  karmaService.getAllKarma();
            System.out.println(karmaList);
            model.addAttribute("karmaList", karmaList);

            model.addAttribute(user);
            BadgesGiven badgesGiven = new BadgesGiven();
            model.addAttribute(badgesGiven);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("login");
            return modelAndView;
        }
    }


    @GetMapping("/password-reset")
    public String password()
    {
        return "forgot-password";
    }

       @GetMapping("/")
    public String dash()
    {
        return "Dashboard";
    }

    @GetMapping("/logout")
    public String logout()
    {
        session.removeAttribute("user");
        session.invalidate();
       return "Dashboard";
    }

}





















//    @PostMapping("/login")
//    public ModelAndView loginUser(HttpServletRequest httpServletRequest) {
//
//        String username = httpServletRequest.getParameter("uid");
//        String password = httpServletRequest.getParameter("pswd");
//
//        User user1 = userService.findByUsernameAndPassword(username, password);
//        // httpSession.setAttribute("user1",user1);
//        if ((user1.getUserName().equals(username)) && (user1.getPassword().equals(password))) {
//            //return "Dashboard";
//            ModelAndView modelAndView = new ModelAndView("Dashboard");
//            // modelAndView.addObject("image","/images/"+user1.getFirstName()+".jpeg");
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("login");
//            return modelAndView;
//        }
//
//    }

//HttpSession httpSession;
//
//ht.setAt("user",)
//
//    ht.get("user");
//
//ht.inv();



