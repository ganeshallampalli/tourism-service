package com.tourism.datamodel.service;

import com.tourism.model.CreateToDoRequestResponse.CreateToDoRequest;
import com.tourism.model.CreateToDoRequestResponse.CreateToDoResponse;
import com.tourism.model.DeleteToDoRequestResponse.DeleteToDoResponse;
import com.tourism.model.FetchToDoRequestResponse.FetchToDoResponse;

public interface ToDoDAOService {

	CreateToDoResponse saveToDo(CreateToDoRequest createToDoRequest);

	FetchToDoResponse getAllToDo();

	DeleteToDoResponse deleteToDo(Integer id);
}
