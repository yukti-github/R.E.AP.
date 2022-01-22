package com.project.reap.service;

import com.project.reap.Entity.BadgesGiven;
import com.project.reap.Repository.BadgesGivenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BadgesGivenService  {

    @Autowired
    BadgesGivenRepository badgesGivenRepository;

    public void save(BadgesGiven badgesGiven)
    {
        badgesGivenRepository.save(badgesGiven);
    }

    public List<BadgesGiven> getPosts(){

        return badgesGivenRepository.findAllByOrderByIdDesc();
    }

}
