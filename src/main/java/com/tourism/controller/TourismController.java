package com.tourism.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.datamodel.service.CruiseDAOService;
import com.tourism.datamodel.service.FeedbackDAOService;
import com.tourism.datamodel.service.UserDAOService;
import com.tourism.model.CreateCruiseRequestResponse.CreateCruiseRequest;
import com.tourism.model.CreateCruiseRequestResponse.CreateCruiseResponse;
import com.tourism.model.FeedBackRequestResponse.FeedBackRequest;
import com.tourism.model.FeedBackRequestResponse.FeedBackResponse;
import com.tourism.model.FetchCruiseRequestResponse.FetchCruiseResponse;
import com.tourism.model.LoginUserRequestResponse.LoginUserRequest;
import com.tourism.model.LoginUserRequestResponse.LoginUserResponse;
import com.tourism.model.RegisterUserRequestResponse.RegisterUserRequest;
import com.tourism.model.RegisterUserRequestResponse.RegisterUserResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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

	@GetMapping("v1/cruises")
	@ApiOperation(value = "Fetch all Cruises", response = FetchCruiseResponse.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Fetched Successfully"),
			@ApiResponse(code = 404, message = "API Not Found") })
	public @ResponseBody FetchCruiseResponse getAllCruises() {
		return cruiseDAOService.getAllCruises();
	}
}
