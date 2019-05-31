package com.tourism.datamodel.repository;

import com.tourism.datamodel.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

	Role findByRoleType(String roleType);
}
