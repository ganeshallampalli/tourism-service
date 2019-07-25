package com.tourism.datamodel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tourism.datamodel.ToDo;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Integer> {

	@SuppressWarnings("unchecked")
	ToDo save(ToDo thingsToDo);

	List<ToDo> findAll();

	ToDo findAllById(Integer id);
}
