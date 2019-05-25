package com.tourism.datamodel.DAOService;

import com.tourism.model.BaseResponse;
import com.tourism.model.RegisterUserRequest;
import com.tourism.model.RegisterUserResponse;

public interface UserDAOService {

    BaseResponse<RegisterUserResponse> createUser(RegisterUserRequest registerUserRequest);
}
