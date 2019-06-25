package com.tourism.datamodel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.datamodel.Cuisine;
import com.tourism.datamodel.repository.CuisineRepository;
import com.tourism.datamodel.service.CuisineDAOService;
import com.tourism.model.CreateCuisineRequestResponse.CreateCuisineRequest;
import com.tourism.model.CreateCuisineRequestResponse.CreateCuisineResponse;
import com.tourism.model.DeleteCuisineRequestResponse.DeleteCuisineResponse;
import com.tourism.model.FetchCuisineRequestResponse.CuisineRespone;
import com.tourism.model.FetchCuisineRequestResponse.FetchCuisineResponse;

@Service
public class CuisineDAOServiceImpl implements CuisineDAOService {

	@Autowired
	private CuisineRepository cuisineRepository;

	@Override
	public CreateCuisineResponse saveCuisine(CreateCuisineRequest createCuisineRequest) {
		CreateCuisineResponse createCuisineResponse = new CreateCuisineResponse();
		if (null == createCuisineRequest.getId()) {
			Cuisine cuisine = new Cuisine();
			cuisine.setName(createCuisineRequest.getName());
			cuisine.setDescription(createCuisineRequest.getDescription());
			cuisine.setImage(createCuisineRequest.getEncodedImage());
			cuisine.setCost(createCuisineRequest.getCost());
			cuisine.setAdditionalLink(createCuisineRequest.getAdditionalLink());

			try {
				Cuisine savedCuisine = cuisineRepository.save(cuisine);
				if (null == savedCuisine) {
					createCuisineResponse.setCode("2004");
					createCuisineResponse.setMessage("Unexpected Error Occurred, Please try again");
				} else {
					createCuisineResponse.setCode("200");
					createCuisineResponse.setMessage("Cuisine Saved Successfully");
				}
			} catch (Exception e) {
				createCuisineResponse.setCode("2005");
				createCuisineResponse
						.setMessage("It seems that there is an issue while saving the data. Please try again");
			}
		} else {
			Cuisine editCuisine = cuisineRepository.findAllById(createCuisineRequest.getId());
			editCuisine.setDescription(createCuisineRequest.getDescription());
			editCuisine.setImage(createCuisineRequest.getEncodedImage());
			editCuisine.setName(createCuisineRequest.getName());
			editCuisine.setAdditionalLink(createCuisineRequest.getAdditionalLink());
			try {
				cuisineRepository.save(editCuisine);
				createCuisineResponse.setCode("200");
				createCuisineResponse.setMessage("Edited Cruise successfully");
			} catch (Exception e) {
				createCuisineResponse.setCode("2021");
				createCuisineResponse
						.setMessage("It seems that there is an issue while saving the data. Please try again");
			}
		}
		return createCuisineResponse;
	}

	@Override
	public FetchCuisineResponse getAllCuisines() {
		FetchCuisineResponse fetchCuisineResponse = new FetchCuisineResponse();
		List<CuisineRespone> cuisineResponses = new ArrayList<>();
		try {
			List<Cuisine> dbCuisines = cuisineRepository.findAll();
			dbCuisines.stream().forEach(cuisine -> {
				CuisineRespone cuisineResponse = new CuisineRespone();
				cuisineResponse.setDescription(cuisine.getDescription());
				cuisineResponse.setEncodedImage(cuisine.getImage());
				cuisineResponse.setName(cuisine.getName());
				cuisineResponse.setId(cuisine.getId());
				cuisineResponse.setCost(cuisine.getCost());
				cuisineResponse.setAdditionalLink(cuisine.getAdditionalLink());
				cuisineResponses.add(cuisineResponse);
			});
			fetchCuisineResponse.setCuisines(cuisineResponses);
			fetchCuisineResponse.setCode("200");
			fetchCuisineResponse.setMessage("Fetched successfully");
		} catch (Exception e) {
			fetchCuisineResponse.setCode("2006");
			fetchCuisineResponse
					.setMessage("It seems that there is an issue while fetching the data. Please try again");
		}
		return fetchCuisineResponse;
	}

	@Override
	public DeleteCuisineResponse deleteCuisine(Integer id) {
		DeleteCuisineResponse deleteCuisineResponse = new DeleteCuisineResponse();
		try {
			Cuisine cuisine = cuisineRepository.findAllById(id);
			if (null == cuisine) {
				deleteCuisineResponse.setCode("2016");
				deleteCuisineResponse.setMessage("Cuisine doesn't exits in the system");
			} else {
				cuisineRepository.delete(cuisine);
				deleteCuisineResponse.setCode("200");
				deleteCuisineResponse.setMessage("Deleted Things To Do scuccesfully");
			}
		} catch (Exception e) {
			deleteCuisineResponse.setCode("2017");
			deleteCuisineResponse
					.setMessage("It seems that there is an issue while deleting the data. Please try again");
		}
		return deleteCuisineResponse;
	}
}
