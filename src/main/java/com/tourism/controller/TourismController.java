package com.tourism.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.datamodel.service.CruiseDAOService;
import com.tourism.datamodel.service.CuisineDAOService;
import com.tourism.datamodel.service.FeedbackDAOService;
import com.tourism.datamodel.service.ThingsToDoDAOService;
import com.tourism.datamodel.service.UserDAOService;
import com.tourism.model.CreateCruiseRequestResponse.CreateCruiseRequest;
import com.tourism.model.CreateCruiseRequestResponse.CreateCruiseResponse;
import com.tourism.model.CreateCuisineRequestResponse.CreateCuisineRequest;
import com.tourism.model.CreateCuisineRequestResponse.CreateCuisineResponse;
import com.tourism.model.CreateThingsToDoRequestResponse.CreateThingsToDoRequest;
import com.tourism.model.CreateThingsToDoRequestResponse.CreateThingsToDoResponse;
import com.tourism.model.DeleteCruiseRequestResponse.DeleteCruiseResponse;
import com.tourism.model.DeleteCuisineRequestResponse.DeleteCuisineResponse;
import com.tourism.model.DeleteThingsToDoRequestResponse.DeleteThingsToDoResponse;
import com.tourism.model.FeedBackRequestResponse.FeedBackRequest;
import com.tourism.model.FeedBackRequestResponse.FeedBackResponse;
import com.tourism.model.FetchCruiseRequestResponse.FetchCruiseResponse;
import com.tourism.model.FetchCuisineRequestResponse.FetchCuisineResponse;
import com.tourism.model.FetchFeedBackRequestResponse.FetchFeedBackResponse;
import com.tourism.model.FetchThingsToDoRequestResponse.FetchThingsToDoResponse;
import com.tourism.model.FetchUsersRequestResponse.FetchUsersResponse;
import com.tourism.model.LoginUserRequestResponse.LoginUserRequest;
import com.tourism.model.LoginUserRequestResponse.LoginUserResponse;
import com.tourism.model.RegisterUserRequestResponse.RegisterUserRequest;
import com.tourism.model.RegisterUserRequestResponse.RegisterUserResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@Api(value = "Api's for Tourism")
public class TourismController {

	@Autowired
	private UserDAOService userDAOService;

	@Autowired
	private FeedbackDAOService feedbackDAOService;

	@Autowired
	private CruiseDAOService cruiseDAOService;

	@Autowired
	private CuisineDAOService cuisineDAOService;

	@Autowired
	private ThingsToDoDAOService thingsToDoDAOService;

	@PostMapping("/v1/login")
	@ApiOperation(value = "Login User API", response = String.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Login Successful"),
			@ApiResponse(code = 404, message = "API Not Found") })
	public LoginUserResponse login(@RequestBody LoginUserRequest loginUserRequest) {
		return userDAOService.loginUser(loginUserRequest);
	}

	@PostMapping("/v1/register")
	@ResponseBody
	@ApiOperation(value = "Register User API", response = RegisterUserResponse.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Registration Successful"),
			@ApiResponse(code = 404, message = "API Not Found") })
	public RegisterUserResponse register(@RequestBody RegisterUserRequest registerUserRequest) {
		return userDAOService.createUser(registerUserRequest);
	}

	@PostMapping("/v1/feedback")
	@ResponseBody
	@ApiOperation(value = "Submit FeedBack API", response = FeedBackResponse.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Saved Successfully"),
			@ApiResponse(code = 404, message = "API Not Found") })
	public FeedBackResponse submitFeedBack(@RequestBody FeedBackRequest feedBackRequest) {
		return feedbackDAOService.submitFeedback(feedBackRequest);
	}

	@PostMapping("v1/cruise")
	@ApiOperation(value = "Create Cruise", response = CreateCruiseResponse.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Saved Successfully"),
			@ApiResponse(code = 404, message = "API Not Found") })
	public @ResponseBody CreateCruiseResponse createCruise(@RequestBody CreateCruiseRequest createCruiseRequest) {
		return cruiseDAOService.saveCruise(createCruiseRequest);
	}

	@GetMapping("v1/cruise")
	@ApiOperation(value = "Fetch all Cruises", response = FetchCruiseResponse.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Fetched Successfully"),
			@ApiResponse(code = 404, message = "API Not Found") })
	public @ResponseBody FetchCruiseResponse getAllCruises() {
		return cruiseDAOService.getAllCruises();
	}

	@PostMapping("v1/cuisine")
	@ApiOperation(value = "Create Cuisine", response = CreateCruiseResponse.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Saved Successfully"),
			@ApiResponse(code = 404, message = "API Not Found") })
	public @ResponseBody CreateCuisineResponse createCuisine(@RequestBody CreateCuisineRequest createCuisineRequest) {
		return cuisineDAOService.saveCuisine(createCuisineRequest);
	}

	@GetMapping("v1/cuisine")
	@ApiOperation(value = "Fetch all Cuisines", response = FetchThingsToDoResponse.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Fetched Successfully"),
			@ApiResponse(code = 404, message = "API Not Found") })
	public @ResponseBody FetchCuisineResponse getAllCuisines() {
		return cuisineDAOService.getAllCuisines();
	}

	@PostMapping("v1/thingsToDo")
	@ApiOperation(value = "Create ThingsToDo", response = CreateCruiseResponse.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Saved Successfully"),
			@ApiResponse(code = 404, message = "API Not Found") })
	public @ResponseBody CreateThingsToDoResponse createThingsToDo(
			@RequestBody CreateThingsToDoRequest createThingsToDoRequest) {
		return thingsToDoDAOService.saveThingsToDo(createThingsToDoRequest);
	}

	@GetMapping("v1/thingsToDo")
	@ApiOperation(value = "Fetch all ThingsToDo Itemes", response = FetchThingsToDoResponse.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Fetched Successfully"),
			@ApiResponse(code = 404, message = "API Not Found") })
	public @ResponseBody FetchThingsToDoResponse getAllThingsToDo() {
		return thingsToDoDAOService.getAllThingsToDo();
	}

	@GetMapping("v1/feedback")
	@ApiOperation(value = "Fetch all Feedbacks", response = FetchFeedBackResponse.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Fetched Successfully"),
			@ApiResponse(code = 404, message = "API Not Found") })
	public @ResponseBody FetchFeedBackResponse getAllFeedbacks() {
		return feedbackDAOService.getAllFeedbacks();
	}

	@DeleteMapping("v1/cruise/{id}")
	@ApiOperation(value = "Delete cruise", response = DeleteCruiseResponse.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Deleted Successfully"),
			@ApiResponse(code = 404, message = "API Not Found") })
	public DeleteCruiseResponse deleteCruise(@PathVariable("id") Integer id) {
		return cruiseDAOService.deleteCruise(id);
	}

	@DeleteMapping("v1/cuisine/{id}")
	@ApiOperation(value = "Delete cruise", response = DeleteCuisineResponse.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Deleted Successfully"),
			@ApiResponse(code = 404, message = "API Not Found") })
	public DeleteCuisineResponse deleteCuisine(@PathVariable("id") Integer id) {
		return cuisineDAOService.deleteCuisine(id);
	}

	@DeleteMapping("v1/thingsToDo/{id}")
	@ApiOperation(value = "Delete cruise", response = DeleteThingsToDoResponse.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Deleted Successfully"),
			@ApiResponse(code = 404, message = "API Not Found") })
	public DeleteThingsToDoResponse deleteThingsToDo(@PathVariable("id") Integer id) {
		return thingsToDoDAOService.deleteThingsToDo(id);
	}

	@GetMapping("v1/users")
	@ApiOperation(value = "Retrieve all users", response = DeleteThingsToDoResponse.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Fetched Successfully"),
			@ApiResponse(code = 404, message = "API Not Found") })
	public FetchUsersResponse fetchAllUsers() {
		return userDAOService.fetchAllUsers();
	}
}
