package com.tourism.datamodel.service;

import com.tourism.model.LoginUserRequestResponse.LoginUserRequest;
import com.tourism.model.LoginUserRequestResponse.LoginUserResponse;
import com.tourism.model.RegisterUserRequestResponse.RegisterUserRequest;
import com.tourism.model.RegisterUserRequestResponse.RegisterUserResponse;

public interface UserDAOService {

	RegisterUserResponse createUser(RegisterUserRequest registerUserRequest);

	LoginUserResponse loginUser(LoginUserRequest loginUserRequest);

}
