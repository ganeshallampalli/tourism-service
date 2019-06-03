package com.tourism.datamodel.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.datamodel.Cruise;
import com.tourism.datamodel.repository.CruiseRepository;
import com.tourism.datamodel.service.CruiseDAOService;
import com.tourism.model.CreateCruiseRequestResponse.CreateCruiseRequest;
import com.tourism.model.CreateCruiseRequestResponse.CreateCruiseResponse;
import com.tourism.model.FetchCruiseRequestResponse.CruiseResponse;
import com.tourism.model.FetchCruiseRequestResponse.FetchCruiseResponse;

@Service
public class CruiseDAOServiceImpl implements CruiseDAOService {

	@Autowired
	private CruiseRepository cruiseRepository;

	@Override
	public FetchCruiseResponse getAllCruises() {
		FetchCruiseResponse fetchCruiseResponse = new FetchCruiseResponse();
		List<CruiseResponse> cruiseResponses = new ArrayList<>();
		try {
			List<Cruise> dbCruises = cruiseRepository.findAll();
			dbCruises.stream().forEach(cruise -> {
				CruiseResponse cruiseResponse = new CruiseResponse();
				cruiseResponse.setDescription(cruise.getDescription());
				cruiseResponse.setEncodedImages(Arrays.asList(cruise.getImages().split("|")));
				cruiseResponse.setName(cruise.getName());
				cruiseResponse.setId(cruise.getId());
				cruiseResponses.add(cruiseResponse);
			});
			fetchCruiseResponse.setCruises(cruiseResponses);
			fetchCruiseResponse.setCode("200");
			fetchCruiseResponse.setMessage("Fetched successfully");
		} catch (Exception e) {
			fetchCruiseResponse.setCode("2001");
			fetchCruiseResponse.setMessage("It seems that there is an issue while fetching the data. Please try again");
		}
		return fetchCruiseResponse;
	}

	@Override
	public CreateCruiseResponse saveCruise(CreateCruiseRequest createCruiseRequest) {
		CreateCruiseResponse createCruiseResponse = new CreateCruiseResponse();
		Cruise cruise = new Cruise();
		cruise.setName(createCruiseRequest.getName());
		cruise.setDescription(createCruiseRequest.getDescription());
		cruise.setImages(createCruiseRequest.getEncodedImages().stream().collect(Collectors.joining("|")));

		try {
			Cruise savedCruise = cruiseRepository.save(cruise);
			if (null == savedCruise) {
				createCruiseResponse.setCode("2002");
				createCruiseResponse.setMessage("Unexpected Error Occurred, Please try again");
			} else {
				createCruiseResponse.setCode("200");
				createCruiseResponse.setMessage("Cruise Saved Successfully");
			}
		} catch (Exception e) {
			createCruiseResponse.setCode("2003");
			createCruiseResponse.setMessage("It seems that there is an issue while saving the data. Please try again");
		}
		return createCruiseResponse;
	}

}
