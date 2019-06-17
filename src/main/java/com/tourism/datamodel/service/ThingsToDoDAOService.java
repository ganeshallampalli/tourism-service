package com.tourism.datamodel.service;

import com.tourism.model.CreateThingsToDoRequestResponse.CreateThingsToDoRequest;
import com.tourism.model.CreateThingsToDoRequestResponse.CreateThingsToDoResponse;
import com.tourism.model.DeleteThingsToDoRequestResponse.DeleteThingsToDoResponse;
import com.tourism.model.FetchThingsToDoRequestResponse.FetchThingsToDoResponse;

public interface ThingsToDoDAOService {

	CreateThingsToDoResponse saveThingsToDo(CreateThingsToDoRequest createThingsToDoRequest);

	FetchThingsToDoResponse getAllThingsToDo();

	DeleteThingsToDoResponse deleteThingsToDo(Integer id);
}
