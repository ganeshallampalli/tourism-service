package com.tourism.datamodel.DAOService.impl;

import com.tourism.datamodel.DAOService.UserDAOService;
import com.tourism.datamodel.Role;
import com.tourism.datamodel.User;
import com.tourism.datamodel.repository.RoleRepository;
import com.tourism.datamodel.repository.UserRepository;
import com.tourism.model.BaseResponse;
import com.tourism.model.RegisterUserRequest;
import com.tourism.model.RegisterUserResponse;
import com.tourism.util.UserIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDAOServiceImpl implements UserDAOService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public BaseResponse<RegisterUserResponse> createUser(RegisterUserRequest registerUserRequest) {
        BaseResponse<RegisterUserResponse> baseResponse = new BaseResponse();

        User checkUser = userRepository.findByEmailId(registerUserRequest.getEmail());
        if (null != checkUser) {
            baseResponse.setCode("1001");
            baseResponse.setMessage("There exists a user already with the given email");
        } else {
            User user = new User();
            user.setEmailId(registerUserRequest.getEmail());
            user.setFirstName(registerUserRequest.getFirstName());
            user.setLastName(registerUserRequest.getLastName());
            user.setUserId(UserIdUtil.createUserId((registerUserRequest.getFirstName() + registerUserRequest.getLastName())).trim().replace(" ", ""));
            user.setPhNo(registerUserRequest.getPhNo());
            user.setPassword(registerUserRequest.getPassword());

            Role role = roleRepository.findByRoleType(registerUserRequest.getRole());
            user.setRoleId(role.getId());

            try {
                userRepository.save(user);
                baseResponse.setCode("200");
                baseResponse.setMessage("Registered Successfully");
            } catch (Exception ex) {
                baseResponse.setCode("1002");
                baseResponse.setMessage("It seems that there is an issue while saving the data. Please try again");
            }
        }
        return baseResponse;
    }
}
