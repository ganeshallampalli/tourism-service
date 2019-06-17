package com.tourism.datamodel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.datamodel.ThingsToDo;
import com.tourism.datamodel.repository.ThingsToDoRepository;
import com.tourism.datamodel.service.ThingsToDoDAOService;
import com.tourism.model.CreateThingsToDoRequestResponse.CreateThingsToDoRequest;
import com.tourism.model.CreateThingsToDoRequestResponse.CreateThingsToDoResponse;
import com.tourism.model.DeleteThingsToDoRequestResponse.DeleteThingsToDoResponse;
import com.tourism.model.FetchThingsToDoRequestResponse.FetchThingsToDoResponse;
import com.tourism.model.FetchThingsToDoRequestResponse.ThingsToDoResponse;

@Service
public class ThingsToDoDAOServiceImpl implements ThingsToDoDAOService {

	@Autowired
	private ThingsToDoRepository thingsToDoRepository;

	@Override
	public CreateThingsToDoResponse saveThingsToDo(CreateThingsToDoRequest createThingsToDoRequest) {
		CreateThingsToDoResponse createThingsToDoResponse = new CreateThingsToDoResponse();
		ThingsToDo thingsToDo = new ThingsToDo();
		thingsToDo.setName(createThingsToDoRequest.getName());
		thingsToDo.setDescription(createThingsToDoRequest.getDescription());
		thingsToDo.setImage(createThingsToDoRequest.getEncodedImage());
		thingsToDo.setTimeSpent(createThingsToDoRequest.getAvgTimeSpent());

		try {
			ThingsToDo savedThingsToDo = thingsToDoRepository.save(thingsToDo);
			if (null == savedThingsToDo) {
				createThingsToDoResponse.setCode("2007");
				createThingsToDoResponse.setMessage("Unexpected Error Occurred, Please try again");
			} else {
				createThingsToDoResponse.setCode("200");
				createThingsToDoResponse.setMessage("Cuisine Saved Successfully");
			}
		} catch (Exception e) {
			createThingsToDoResponse.setCode("2008");
			createThingsToDoResponse
					.setMessage("It seems that there is an issue while saving the data. Please try again");
		}
		return createThingsToDoResponse;
	}

	@Override
	public FetchThingsToDoResponse getAllThingsToDo() {
		FetchThingsToDoResponse fetchThingsToDoResponse = new FetchThingsToDoResponse();
		List<ThingsToDoResponse> thingsToDoResonses = new ArrayList<>();
		try {
			List<ThingsToDo> dbCuisines = thingsToDoRepository.findAll();
			dbCuisines.stream().forEach(thingsToDo -> {
				ThingsToDoResponse cuisineResponse = new ThingsToDoResponse();
				cuisineResponse.setDescription(thingsToDo.getDescription());
				cuisineResponse.setEncodedImage(thingsToDo.getImage());
				cuisineResponse.setName(thingsToDo.getName());
				cuisineResponse.setId(thingsToDo.getId());
				cuisineResponse.setTimeSpent(thingsToDo.getTimeSpent());
				thingsToDoResonses.add(cuisineResponse);
			});
			fetchThingsToDoResponse.setThingsToDo(thingsToDoResonses);
			fetchThingsToDoResponse.setCode("200");
			fetchThingsToDoResponse.setMessage("Fetched successfully");
		} catch (Exception e) {
			fetchThingsToDoResponse.setCode("2009");
			fetchThingsToDoResponse
					.setMessage("It seems that there is an issue while fetching the data. Please try again");
		}
		return fetchThingsToDoResponse;
	}

	@Override
	public DeleteThingsToDoResponse deleteThingsToDo(Integer id) {
		DeleteThingsToDoResponse deleteThingsToDoResponse = new DeleteThingsToDoResponse();
		try {
			ThingsToDo thingsToDo = thingsToDoRepository.findAllById(id);
			if (null == thingsToDo) {
				deleteThingsToDoResponse.setCode("2014");
				deleteThingsToDoResponse.setMessage("Things To DO Item doesn't exits in the system");
			} else {
				thingsToDoRepository.delete(thingsToDo);
				deleteThingsToDoResponse.setCode("200");
				deleteThingsToDoResponse.setMessage("Deleted Things To Do scuccesfully");
			}
		} catch (Exception e) {
			deleteThingsToDoResponse.setCode("2015");
			deleteThingsToDoResponse
					.setMessage("It seems that there is an issue while deleting the data. Please try again");
		}
		return deleteThingsToDoResponse;
	}
}
