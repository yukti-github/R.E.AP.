package com.project.reap.Events;

import com.project.reap.Entity.Star;
import com.project.reap.Entity.Star;
import com.project.reap.Repository.StarRepository;
import com.project.reap.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StarBootstrap {

    @Autowired
    StarService starService;

    public void initStar() {
        List<Star> stars = starService.findAll();
        if (stars.size() == 0) {
            Star gold = new Star();
            gold.setName("Gold Star");
            gold.setWeight(30);
            starService.save(gold);

            Star silver = new Star();
            silver.setName("Silver Star");
            silver.setWeight(20);
            starService.save(silver);

            Star bronze = new Star();
            bronze.setName("Bronze Star");
            bronze.setWeight(10);
            starService.save(bronze);
        } else return;
    }
}