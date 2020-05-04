package com.shl.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songhengliang
 * @date 2020/5/2
 */
@RestController
public class HelloController {
  /**
   * 正常访问接口
   * @return
   */
  @RequestMapping("/sayBoot")
  public String sayBoot(){
    return "hello boot!";
  }

  /**
   * 异常访问接口
   * @return
   */
  @RequestMapping("/exception")
  public String exception(){
    int i = 1/0;
    return "hello boot!";
  }
}
