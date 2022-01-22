package com.project.reap.Repository;

import com.project.reap.Entity.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole,Integer> {
    UserRole findById(int i);
}
