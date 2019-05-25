package com.tourism.controller;

import com.tourism.datamodel.DAOService.RoleDAOService;
import com.tourism.datamodel.DAOService.UserDAOService;
import com.tourism.model.BaseResponse;
import com.tourism.model.RegisterUserRequest;
import com.tourism.model.RegisterUserResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Tourism Controller
 */

@RestController
@RequestMapping("/api")
@Api(value = "Api's for Tourism")
public class TourismController {

    @Autowired
    private UserDAOService userDAOService;

    @GetMapping("/v1/login")
    @ApiOperation(value = "Login User API", response = String.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Login Successful"),
            @ApiResponse(code = 404, message = "API Not Found")

    })
    public String login(@RequestParam(value = "username") String userName, @RequestParam(value = "password") String password) {
        return "Login Successful";
    }

    @PostMapping("/v1/register")
    @ResponseBody
    @ApiOperation(value = "Register User API", response = RegisterUserResponse.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Registration Successful"),
            @ApiResponse(code = 404, message = "API Not Found")

    })
    public BaseResponse<RegisterUserResponse> register(@RequestBody RegisterUserRequest registerUserRequest) {
        return userDAOService.createUser(registerUserRequest);
    }
}
