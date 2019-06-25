package com.tourism.datamodel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.datamodel.Cruise;
import com.tourism.datamodel.repository.CruiseRepository;
import com.tourism.datamodel.service.CruiseDAOService;
import com.tourism.model.CreateCruiseRequestResponse.CreateCruiseRequest;
import com.tourism.model.CreateCruiseRequestResponse.CreateCruiseResponse;
import com.tourism.model.DeleteCruiseRequestResponse.DeleteCruiseResponse;
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
				cruiseResponse.setEncodedImage(cruise.getImage());
				cruiseResponse.setName(cruise.getName());
				cruiseResponse.setId(cruise.getId());
				cruiseResponse.setAdditionalLink(cruise.getAdditionalLink());
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
		if (null == createCruiseRequest.getId()) {
			Cruise cruise = new Cruise();
			cruise.setName(createCruiseRequest.getName());
			cruise.setDescription(createCruiseRequest.getDescription());
			cruise.setImage(createCruiseRequest.getEncodedImage());
			cruise.setAdditionalLink(createCruiseRequest.getAdditionalLink());

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
				createCruiseResponse
						.setMessage("It seems that there is an issue while saving the data. Please try again");
			}
		} else {
			Cruise editCruise = cruiseRepository.findAllById(createCruiseRequest.getId());
			editCruise.setDescription(createCruiseRequest.getDescription());
			editCruise.setImage(createCruiseRequest.getEncodedImage());
			editCruise.setName(createCruiseRequest.getName());
			editCruise.setAdditionalLink(createCruiseRequest.getAdditionalLink());
			try {
				cruiseRepository.save(editCruise);
				createCruiseResponse.setCode("200");
				createCruiseResponse.setMessage("Edited Cruise successfully");
			} catch (Exception e) {
				createCruiseResponse.setCode("2018");
				createCruiseResponse
						.setMessage("It seems that there is an issue while saving the data. Please try again");
			}
		}
		return createCruiseResponse;
	}

	@Override
	public DeleteCruiseResponse deleteCruise(Integer id) {
		DeleteCruiseResponse deleteCruiseResponse = new DeleteCruiseResponse();
		try {
			Cruise cruise = cruiseRepository.findAllById(id);
			if (null == cruise) {
				deleteCruiseResponse.setCode("2011");
				deleteCruiseResponse.setMessage("Cruise doesn't exits in the system");
			} else {
				cruiseRepository.delete(cruise);
				deleteCruiseResponse.setCode("200");
				deleteCruiseResponse.setMessage("Deleted Cruise scuccesfully");
			}
		} catch (Exception e) {
			deleteCruiseResponse.setCode("2013");
			deleteCruiseResponse
					.setMessage("It seems that there is an issue while deleting the data. Please try again");
		}
		return deleteCruiseResponse;
	}

}
