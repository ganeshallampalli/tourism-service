package com.tourism.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Api(value = "Api's for Tourism")
public class TourismController {


    @GetMapping("/v1/login")
    @ApiOperation(value = "Login API", response = String.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Login Successful"),
            @ApiResponse(code = 404, message = "API Not Found")

    })
    public String login(@RequestParam(value = "username") String userName, @RequestParam(value = "password") String password) {
        return "Login Successful";
    }
}
