package com.user.userservice.controller;

import com.user.userservice.VO.ResponseTemplateVO;
import com.user.userservice.entity.User;
import com.user.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
@Autowired
    private UserService userService;


@PostMapping("/")
public User saveUser(@RequestBody  User user){
    log.info("In controller method of save user");
    return userService.saveUser(user);
}


@GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
      log.info("in controller method of get user with department");
    return userService.getUserWithDepartment(userId);
}


}
