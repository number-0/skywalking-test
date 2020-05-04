package com.shl.mysql.controller;

import com.shl.mysql.pojo.User;
import com.shl.mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author songhengliang
 * @date 2020/5/3
 */
@RestController
public class MysqlController {
  @Autowired
  private UserRepository userRepository;

  @GetMapping("/users")
  public List<User> findAll(){
    List<User> result = new ArrayList<>();
    userRepository.findAll().forEach(result::add);
    return result;
  }
}

