package com.tourism.datamodel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.datamodel.ToDo;
import com.tourism.datamodel.repository.ToDoRepository;
import com.tourism.datamodel.service.ToDoDAOService;
import com.tourism.model.CreateToDoRequestResponse.CreateToDoRequest;
import com.tourism.model.CreateToDoRequestResponse.CreateToDoResponse;
import com.tourism.model.DeleteToDoRequestResponse.DeleteToDoResponse;
import com.tourism.model.FetchToDoRequestResponse.FetchToDoResponse;
import com.tourism.model.FetchToDoRequestResponse.ToDoResponse;

@Service
public class ToDoDAOServiceImpl implements ToDoDAOService {

	@Autowired
	private ToDoRepository toDoRepository;

	@Override
	public CreateToDoResponse saveToDo(CreateToDoRequest createToDoRequest) {

		CreateToDoResponse createToDoResponse = new CreateToDoResponse();
		ToDo toDo = new ToDo();
		toDo.setTitle(createToDoRequest.getTitle());
		toDo.setCompleted(createToDoRequest.getCompleted());

		try {
			ToDo savedToDo = toDoRepository.save(toDo);
			if (null == savedToDo) {
				createToDoResponse.setCode("5001");
				createToDoResponse.setMessage("Unexpected Error Occurred, Please try again");
			} else {
				createToDoResponse.setCode("200");
				createToDoResponse.setMessage("To Do Saved Successfully");
			}
		} catch (Exception e) {
			createToDoResponse.setCode("5002");
			createToDoResponse.setMessage("It seems that there is an issue while saving the data. Please try again");
		}

		return createToDoResponse;
	}

	@Override
	public FetchToDoResponse getAllToDo() {

		FetchToDoResponse fetchToDoResponse = new FetchToDoResponse();
		List<ToDoResponse> toDoResponses = new ArrayList<>();
		try {
			List<ToDo> dbToDos = toDoRepository.findAll();
			dbToDos.stream().forEach(toDo -> {
				ToDoResponse toDoResponse = new ToDoResponse();
				toDoResponse.setId(toDo.getId());
				toDoResponse.setCompleted(toDo.getCompleted());
				toDoResponse.setTitle(toDo.getTitle());
				toDoResponses.add(toDoResponse);
			});
			fetchToDoResponse.setToDoResponses(toDoResponses);
			fetchToDoResponse.setCode("200");
			fetchToDoResponse.setMessage("Fetched successfully");
		} catch (Exception e) {
			fetchToDoResponse.setCode("5003");
			fetchToDoResponse.setMessage("It seems that there is an issue while fetching the data. Please try again");
		}
		return fetchToDoResponse;
	}

	@Override
	public DeleteToDoResponse deleteToDo(Integer id) {
		DeleteToDoResponse deleteToDoResponse = new DeleteToDoResponse();
		try {
			ToDo thingsToDo = toDoRepository.findAllById(id);
			if (null == thingsToDo) {
				deleteToDoResponse.setCode("5004");
				deleteToDoResponse.setMessage("Things To Do Item doesn't exits in the system");
			} else {
				toDoRepository.delete(thingsToDo);
				deleteToDoResponse.setCode("200");
				deleteToDoResponse.setMessage("Deleted To Do scuccesfully");
			}
		} catch (Exception e) {
			deleteToDoResponse.setCode("5005");
			deleteToDoResponse
					.setMessage("It seems that there is an issue while deleting the data. Please try again");
		}
		return deleteToDoResponse;
	}
}
