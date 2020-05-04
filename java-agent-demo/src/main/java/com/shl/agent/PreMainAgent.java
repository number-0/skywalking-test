package com.shl.agent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;
import java.lang.instrument.Instrumentation;

/**
 * @author songhengliang
 * @date 2020/5/4
 */
public class PreMainAgent {

  /**
   * 在这个 premain 函数中，开发者可以进行对类的各种操作。
   *
   * 1、agentArgs 是 premain 函数得到的程序参数，随同 “– javaagent”一起传入。与 main 函数不同的是，
   * 这个参数是一个字符串而不是一个字符串数组，如果程序参数有多个，程序将自行解析这个字符串。
   * eg：-javaagent:路径\java-agent-demo-1.0-SNAPSHOT.jar=HELLOAGENT，agentArgs就是HELLOAGENT
   *
   * 2、Inst 是一个 java.lang.instrument.Instrumentation 的实例，由 JVM 自动传入。*
   * java.lang.instrument.Instrumentation 是 instrument 包中定义的一个接口，也是这个包的核心部分，
   * 集中了其中几乎所有的功能方法，例如类定义的转换和操作等等。
   *
   * @param agentArgs
   * @param inst
   */
//  public static void premain(String agentArgs, Instrumentation inst) {
//      System.out.println("=========premain方法执行1========");
//      System.out.println(agentArgs);
//  }


  /**
   * 如果不存在 premain(String agentArgs, Instrumentation inst)
   * 才会执行 premain(String agentArgs)
   * @param agentArgs
   */
//  public static void premain(String agentArgs) {
//      System.out.println("=========premain方法执行2========");
//      System.out.println(agentArgs);
//  }


  /**
   * ByteBuddy是一个操作字节码的工具，也对agent提供了一个很好的支持
   * @param agentArgs
   * @param inst
   */
  public static void premain(String agentArgs, Instrumentation inst) {
    //构建AgentBuilder.Transformer是为了对方法进行拦截

    //创建一个转换器，转换器可以修改类的实现
    //ByteBuddy对java agent提供了转换器的实现，直接使用即可
    AgentBuilder.Transformer transformer = new AgentBuilder.Transformer() {
      @Override
      public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder,
          TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule) {
        return builder
            // method指定哪些方法要被拦截，ElementMatchers.<MethodDescription>any()代表拦截任意方法
            .method(ElementMatchers.<MethodDescription>any())
            // 声明intercept拦截器，拦截到的方法委托给TimeInterceptor
            .intercept(MethodDelegation.to(MyInterceptor.class));
      }
    };
    new AgentBuilder // Byte Buddy专门有个AgentBuilder来处理Java Agent的场景
        .Default()
        // 指定agent拦截的类，根据包名前缀拦截类
        .type(ElementMatchers.nameStartsWith("com.shl.agent"))
        // 拦截到的类由transformer处理
        .transform(transformer)
        //将agent配置安装到Instrumentation中
        .installOn(inst);


    /*
    先生成一个转换器，ByteBuddy提供了java agent专用的转换器。
    通过实现Transformer接口利用builder对象来创建一个转换器。
    转换器可以配置拦截方法的格式，比如用名称，本例中拦截所有方法，并定义一个拦截器类MyInterceptor。
    创建完拦截器之后可以通过Byte Buddy的AgentBuilder建造者来构建一个agent对象。AgentBuilder可
    以对指定的包名前缀来生效，同时需要指定转换器对象。
     */
  }
}

