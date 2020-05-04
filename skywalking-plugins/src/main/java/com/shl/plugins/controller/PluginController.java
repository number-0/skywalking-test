package com.shl.plugins.controller;

import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取追踪id
 *
 * 需要引入：
 *  <dependency>
     <groupId>org.apache.skywalking</groupId>
     <artifactId>apm-toolkit-trace</artifactId>
     <version>${skywalking.version}</version>
    </dependency>
 * @author songhengliang
 * @date 2020/5/3
 */
@RestController
public class PluginController {
  /**
   * 获取trace id，可以在RocketBot追踪中进行查询
   *
   * ActiveSpan提供了三个方法进行信息的打印:
   *  error方法会将本次调用变为失败状态，同时可以打印对应的堆栈信息和错误提示。
   *  info方法打印info级别的信息。
   *  debug方法打印debug级别的信息。
   * @return
   */
  @GetMapping("/getTraceId")
  public String getTraceId(){
    //ActiveSpan将数据植入到链路中

    //使当前链路报错，并且提示报错信息
    ActiveSpan.error(new RuntimeException("Test-Error-Throwable"));
    //打印info信息
    ActiveSpan.info("Test-Info-Msg");
    //打印debug信息
    ActiveSpan.debug("Test-debug-Msg");

    return TraceContext.traceId();
  }
}

