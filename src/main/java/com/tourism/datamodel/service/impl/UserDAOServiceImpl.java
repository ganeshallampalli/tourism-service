package com.tourism.datamodel.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.datamodel.Role;
import com.tourism.datamodel.User;
import com.tourism.datamodel.repository.RoleRepository;
import com.tourism.datamodel.repository.UserRepository;
import com.tourism.datamodel.service.UserDAOService;
import com.tourism.model.LoginUserRequestResponse.LoginUserRequest;
import com.tourism.model.LoginUserRequestResponse.LoginUserResponse;
import com.tourism.model.RegisterUserRequestResponse.RegisterUserRequest;
import com.tourism.model.RegisterUserRequestResponse.RegisterUserResponse;
import com.tourism.util.CustomExecption.PasswordException;
import com.tourism.util.EncryptionUtil;
import com.tourism.util.UserIdUtil;

@Service
public class UserDAOServiceImpl implements UserDAOService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOServiceImpl.class);

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
			user.setUserId(
					UserIdUtil.createUserId((registerUserRequest.getFirstName() + registerUserRequest.getLastName()))
							.trim().replace(" ", ""));
			user.setPhNo(registerUserRequest.getPhNo());
			try {
				if (null != registerUserRequest.getPassword() && !registerUserRequest.getPassword().isEmpty()) {
					user.setPassword(EncryptionUtil.encrpyt(registerUserRequest.getPassword()));
				}
			} catch (Exception e) {
				LOGGER.debug("Password Encryption Error");
			}

			Role role = roleRepository.findByRoleType(registerUserRequest.getRole());
			user.setRoleId(role.getId());

			try {
				userRepository.save(user);
				registerUserResponse.setCode("200");
				registerUserResponse.setMessage("Registered Successfully");
			} catch (Exception ex) {
				registerUserResponse.setCode("1002");
				registerUserResponse
						.setMessage("It seems that there is an issue while saving the data. Please try again");
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
					loginUserResponse.setUserName(user.getFirstName() + " " + user.getLastName());
					loginUserResponse.setEmailId(emailId);
					loginUserResponse.setUserId(user.getUserId());
					loginUserResponse.setRole(roleRepository.findAllById(user.getRoleId()).getRoleType());
					loginUserResponse.setCode("200");
					loginUserResponse.setMessage("Login Successful");
				} else {
					loginUserResponse.setCode("1003");
					loginUserResponse.setMessage("Invalid Username or Password");
				}

			} catch (PasswordException e) {
				LOGGER.debug("{}", e.getMessage());
			}
		} else {
			loginUserResponse.setCode("1004");
			loginUserResponse
					.setMessage("There exists no user registered with the given email-id. Please Sign up first!!");
		}

		return loginUserResponse;
	}
}
