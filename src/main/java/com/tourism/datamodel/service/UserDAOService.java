package com.tourism.datamodel.service;

import com.tourism.model.*;

public interface UserDAOService {

	RegisterUserResponse createUser(RegisterUserRequest registerUserRequest);

	LoginUserResponse loginUser(LoginUserRequest loginUserRequest);

}
