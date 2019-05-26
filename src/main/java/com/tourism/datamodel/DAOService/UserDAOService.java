package com.tourism.datamodel.DAOService;

import com.tourism.model.*;

public interface UserDAOService {

    RegisterUserResponse createUser(RegisterUserRequest registerUserRequest);

    LoginUserResponse loginUser(LoginUserRequest loginUserRequest);

}
