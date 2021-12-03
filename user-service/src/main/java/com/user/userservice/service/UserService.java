package com.user.userservice.service;

import com.user.userservice.VO.Department;
import com.user.userservice.VO.ResponseTemplateVO;
import com.user.userservice.entity.User;
import com.user.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

@Autowired
    private UserRepository userRepository;


@Autowired
private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("in save method of user service ");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {

      log.info("in get userwithdeppartment method of service");
             ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
             User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://UNIVERSITY-SERVICE/departments/"+user.getDepartmentId(),Department.class);
        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);
    return  responseTemplateVO;
    }
}
