package com.tourism.datamodel.service;

import com.tourism.model.CreateCruiseRequestResponse.CreateCruiseRequest;
import com.tourism.model.CreateCruiseRequestResponse.CreateCruiseResponse;
import com.tourism.model.FetchCruiseRequestResponse.FetchCruiseResponse;

public interface CruiseDAOService {

	FetchCruiseResponse getAllCruises();

	CreateCruiseResponse saveCruise(CreateCruiseRequest createCruiseRequest);
}
