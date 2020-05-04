package com.shl.alarm.controller;

import com.shl.alarm.pojo.AlarmMessage;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songhengliang
 * @date 2020/5/3
 */
@RestController
public class WebHooks {

  private List<AlarmMessage> lastList = new ArrayList<>();

  @PostMapping("/webhook")
  public void webhook(@RequestBody List<AlarmMessage> alarmMessageList) {
    lastList = alarmMessageList;
  }

  @GetMapping("/show")
  public List<AlarmMessage> show() {
    return lastList;
  }
}
