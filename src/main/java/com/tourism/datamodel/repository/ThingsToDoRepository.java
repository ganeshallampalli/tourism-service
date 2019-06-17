package com.tourism.datamodel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tourism.datamodel.ThingsToDo;

@Repository
public interface ThingsToDoRepository extends CrudRepository<ThingsToDo, Integer> {

	/**
	 * Save Cruise
	 * 
	 * @param cruise
	 * @return {@link ThingsToDo}
	 */
	@SuppressWarnings("unchecked")
	ThingsToDo save(ThingsToDo thingsToDo);

	/**
	 * Fetch all cruises
	 * 
	 * @return {@link List}<{@link ThingsToDo}>
	 */
	List<ThingsToDo> findAll();

	ThingsToDo findAllById(Integer id);
}
