package com.project.reap.Repository;

import com.project.reap.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    public User findByUserNameAndPassword(String userName, String pass);

    @Query("SELECT u from User u where email=:email")
    Optional<User> findByEmail(@Param("email") String email);

    @Query("SELECT u from User u where email=:email")
    User findByMail(@Param("email") String email);

    List<User> findAll();
    @Override
    <S extends User> S save(S entity);
}
