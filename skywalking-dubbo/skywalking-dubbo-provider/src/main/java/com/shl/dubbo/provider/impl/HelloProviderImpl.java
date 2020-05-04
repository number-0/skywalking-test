package com.shl.dubbo.provider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.shl.dubbo.provider.HelloProvider;
import org.springframework.stereotype.Component;

/**
 * @author songhengliang
 * @date 2020/5/2
 */
@Service(interfaceClass = HelloProvider.class)
@Component
public class HelloProviderImpl implements HelloProvider {

  @Override
  public String hello() {
    return "hello skywalking-dubbo";
  }
}
