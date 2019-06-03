package com.tourism.datamodel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tourism.datamodel.Cruise;

@Repository
public interface CruiseRepository extends CrudRepository<Cruise, Integer> {

	/**
	 * Save Cruise
	 * 
	 * @param cruise
	 * @return {@link Cruise}
	 */
	@SuppressWarnings("unchecked")
	Cruise save(Cruise cruise);

	/**
	 * Fetch all cruises
	 * 
	 * @return {@link List}<{@link Cruise}>
	 */
	List<Cruise> findAll();
}
