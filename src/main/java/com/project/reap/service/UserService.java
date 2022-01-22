package com.project.reap.service;


import com.project.reap.Entity.User;
import com.project.reap.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    private static final String dirpath = "/home/yukti/IdeaProjects/reap/src/main/resources/static/images";


    public User saveUser(User user) {

        Path path = Paths.get(dirpath, user.getUserName() + ".jpeg");
        try {
            path = Files.write(path, user.getImage().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setFileName(path.toString());

       return userRepository.save(user);
    }

    public void saveUpdatedUser(User user)
    {
        userRepository.save(user);
    }



    public User checkForLogin(String username,String password)
    {
        if(userRepository.findByUserNameAndPassword(username,password)!=null)
        {
            return userRepository.findByUserNameAndPassword(username, password);
        }
        else {
            return null;
        }
    }

    public Optional<User> findByMail(String mail)
    {
        return userRepository.findByEmail(mail);
    }

    public User findByMailUser(String mail)
    {
        return userRepository.findByMail(mail);
    }

    public List<User> findAll()
    {
      return  userRepository.findAll();
    }

}
