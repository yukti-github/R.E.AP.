package com.project.reap.service;

import com.project.reap.Entity.UserRole;
import com.project.reap.Repository.UserRepository;
import com.project.reap.Repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;

    public UserRole getRole(int i){

        return  userRoleRepository.findById(i);

    }
}
