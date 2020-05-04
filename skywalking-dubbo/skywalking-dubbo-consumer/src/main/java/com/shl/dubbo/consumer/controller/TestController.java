package com.shl.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shl.dubbo.provider.HelloProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songhengliang
 * @date 2020/5/2
 */
@RestController
public class TestController {

  @Reference(url = "dubbo://127.0.0.1:20880")
  private HelloProvider helloProvider;

  @GetMapping("/hello")
  public String hello() {
    return this.helloProvider.hello();
  }
}
