//package com.project.reap.Events;
//
//import com.project.reap.Entity.Karma;
//import com.project.reap.Entity.Star;
//import com.project.reap.service.KarmaService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.event.ApplicationStartedEvent;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//@Component
//public class KarmaBootstrap {
//
//    @Autowired
//    KarmaService karmaService;
//
//    public void init() {
//        List<Karma> karm= karmaService.getAllKarma();
//        if(karm.size()==0) {
//            Karma k1 = new Karma(6, "Extra Miler");
//            Karma k2 = new Karma(3, "Knowledge Sharing");
//            Karma k3 = new Karma(1, "Mentorship");
//            Karma k4 = new Karma(5, "Pat on the back");
//            Karma k5 = new Karma(7, "Customer Delight");
//            Karma k6 = new Karma(4, "Continuous Learning and Improvement");
//            Karma k7 = new Karma(2, "Responsible Freedom");
//            List<Karma> karmaList = new ArrayList<>();
//            karmaList.add(k1);
//            karmaList.add(k2);
//            karmaList.add(k3);
//            karmaList.add(k4);
//            karmaList.add(k5);
//            karmaList.add(k6);
//            karmaList.add(k7);
//
//            karmaService.saveAll(karmaList);
//        }
//        else
//        {
//            return;
//        }
//
//    }
//}
