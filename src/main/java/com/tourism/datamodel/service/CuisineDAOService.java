package com.tourism.datamodel.service;

import com.tourism.model.CreateCuisineRequestResponse.CreateCuisineRequest;
import com.tourism.model.CreateCuisineRequestResponse.CreateCuisineResponse;
import com.tourism.model.DeleteCuisineRequestResponse.DeleteCuisineResponse;
import com.tourism.model.FetchCuisineRequestResponse.FetchCuisineResponse;

public interface CuisineDAOService {

	CreateCuisineResponse saveCuisine(CreateCuisineRequest createCuisineRequest);

	FetchCuisineResponse getAllCuisines();

	DeleteCuisineResponse deleteCuisine(Integer id);
}
