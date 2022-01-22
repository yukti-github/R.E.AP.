//package com.project.reap.controller;
//
//import com.project.reap.Entity.BadgesGiven;
//import com.project.reap.Entity.User;
////import com.project.reap.Events.KarmaBootstrap;
//import com.project.reap.Events.StarBootstrap;
//import com.project.reap.service.BadgesGivenService;
//import com.project.reap.service.KarmaService;
//import com.project.reap.service.StarService;
//import com.project.reap.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpSession;
//
//@Controller
//public class BadgeController {
//
//    @Autowired
//    UserService userService;
//    @Autowired
//    HttpSession session;
//    @Autowired
//    BadgesGivenService badgesGivenService;
//    @Autowired
//    StarService starService;
//    @Autowired
//    KarmaService karmaService;
//   // @Autowired
//    //KarmaBootstrap karmaBootstrap;
//    @Autowired
//    StarBootstrap starBootstrap;
//
//    @PostMapping("/badgesgiven")
//    public ModelAndView setBadgesGiven(@ModelAttribute BadgesGiven badgesGiven, Model model) {
//        badgesGivenService.save(badgesGiven);
//        User user= (User)session.getAttribute("user");
//        model.addAttribute(user);
//        ModelAndView modelAndView = new ModelAndView("Dashboard");
//        modelAndView.addObject("image", "/images/" + user.getFirstName() + ".jpeg");
//        return modelAndView;
//    }
//}
