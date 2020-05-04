package com.shl.agent;

import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * 统计方法调用时间
 * @author songhengliang
 * @date 2020/5/4
 */
public class MyInterceptor {

  /**
   * MyInterceptor就是一个拦截器的实现，统计的调用的时长。
   * 参数中的method是反射出的方法对象，
   * 而callable就是调用对象，可以通过callable.call()方法来执行原方法。
   * @param method
   * @param callable
   * @return
   * @throws Exception
   */
  @RuntimeType //是在运行过程中进行拦截的
  public static Object intercept(@Origin Method method,
      @SuperCall Callable<?> callable)
      throws Exception {
    long start = System.currentTimeMillis();
    try {
      //执行原方法
      return callable.call();
    } finally {
      //打印调用时长
      System.out.println(method.getName() + ":" + (System.currentTimeMillis() - start)  + "ms");
    }
  }
}