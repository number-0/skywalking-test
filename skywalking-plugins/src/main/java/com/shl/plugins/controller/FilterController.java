package com.shl.plugins.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 过滤指定的端点
 * @author songhengliang
 * @date 2020/5/3
 */
@RestController
public class FilterController {
  /**
   * 此接口可以被追踪
   * @return
   */
  @GetMapping("/include")
  public String include(){
    return "include";
  }

  /**
   * 此接口不可被追踪
   * @return
   */
  @GetMapping("/exclude")
  public String exclude(){
    return "exclude";
  }
}
