package com.tourism.datamodel.DAOService.impl;

import com.tourism.datamodel.DAOService.UserDAOService;
import com.tourism.datamodel.Role;
import com.tourism.datamodel.User;
import com.tourism.datamodel.repository.RoleRepository;
import com.tourism.datamodel.repository.UserRepository;
import com.tourism.model.*;
import com.tourism.util.EncryptionUtil;
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
    public RegisterUserResponse createUser(RegisterUserRequest registerUserRequest) {
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();

        User checkUser = userRepository.findByEmailId(registerUserRequest.getEmail());
        if (null != checkUser) {
            registerUserResponse.setCode("1001");
            registerUserResponse.setMessage("There exists a user already with the given email");
        } else {
            User user = new User();
            user.setEmailId(registerUserRequest.getEmail());
            user.setFirstName(registerUserRequest.getFirstName());
            user.setLastName(registerUserRequest.getLastName());
            user.setUserId(UserIdUtil.createUserId((registerUserRequest.getFirstName() + registerUserRequest.getLastName())).trim().replace(" ", ""));
            user.setPhNo(registerUserRequest.getPhNo());
            try {
                user.setPassword(EncryptionUtil.encrpyt(registerUserRequest.getPassword()));
            } catch (Exception e) {
                e.printStackTrace();
            }

            Role role = roleRepository.findByRoleType(registerUserRequest.getRole());
            user.setRoleId(role.getId());

            try {
                userRepository.save(user);
                registerUserResponse.setCode("200");
                registerUserResponse.setMessage("Registered Successfully");
            } catch (Exception ex) {
                registerUserResponse.setCode("1002");
                registerUserResponse.setMessage("It seems that there is an issue while saving the data. Please try again");
            }
        }
        return registerUserResponse;
    }

    @Override
    public LoginUserResponse loginUser(LoginUserRequest loginUserRequest) {
        LoginUserResponse loginUserResponse = new LoginUserResponse();
        String emailId = loginUserRequest.getUserName();
        String password = loginUserRequest.getPassword();
        User user = userRepository.findByEmailId(emailId);
        if (null != user) {
            try {
                String encryptLoginPassword = EncryptionUtil.encrpyt(password);
                if (user.getPassword().equals(encryptLoginPassword)) {
                    loginUserResponse.setUserName(user.getFirstName() + user.getLastName());
                    loginUserResponse.setEmailId(emailId);
                    loginUserResponse.setUserId(user.getUserId());
                    loginUserResponse.setCode("200");
                    loginUserResponse.setMessage("Login Successful");
                } else {
                    loginUserResponse.setCode("1003");
                    loginUserResponse.setMessage("Invalid Username or Password");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            loginUserResponse.setCode("1004");
            loginUserResponse.setMessage("There exists no user registered with the given email-id. Please Sign up first!!");
        }

        return loginUserResponse;
    }
}
