package com.project.reap.service;

import com.project.reap.Entity.Karma;
import com.project.reap.Repository.KarmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KarmaService {
    @Autowired
    KarmaRepository karmaRepository;

    public void save(Karma karma)
    {
        karmaRepository.save(karma);
    }

    public void saveAll(List list)
    {
        karmaRepository.saveAll(list);
    }
    public List<Karma> getAllKarma()
    {
        return karmaRepository.findAll();
    }

   }

