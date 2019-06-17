package com.tourism.datamodel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tourism.datamodel.Cuisine;

@Repository
public interface CuisineRepository extends CrudRepository<Cuisine, Integer> {

	/**
	 * Save Cruise
	 * 
	 * @param cruise
	 * @return {@link Cuisine}
	 */
	@SuppressWarnings("unchecked")
	Cuisine save(Cuisine cuisine);

	/**
	 * Fetch all cruises
	 * 
	 * @return {@link List}<{@link Cuisine}>
	 */
	List<Cuisine> findAll();

	Cuisine findAllById(Integer id);
}
