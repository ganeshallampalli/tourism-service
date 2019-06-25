package com.tourism.datamodel.repository;

import com.tourism.datamodel.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	@SuppressWarnings("unchecked")
	User save(User user);

	User findByEmailId(String emailId);

	List<User> findAllByRoleId(Integer id);
}
