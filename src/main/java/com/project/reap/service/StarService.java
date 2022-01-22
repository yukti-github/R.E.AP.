package com.project.reap.service;

import com.project.reap.Entity.Star;
import com.project.reap.Repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarService {
    @Autowired
    StarRepository starRepository;

    public List<Star> findAll()
    {
       return starRepository.findAll();
    }
     public void save(Star star)
     {
         starRepository.save(star);
     }

     public Star findByname(String star)
     {
         return starRepository.findByName(star);
     }
}
