package com.tourism.datamodel.repository;

import com.tourism.datamodel.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User save(User user);

    User findByEmailId(String emailId);
}
