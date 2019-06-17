package com.tourism.datamodel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tourism.datamodel.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

	Role findByRoleType(String roleType);

	Role findAllById(Integer id);
}
