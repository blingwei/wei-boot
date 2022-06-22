package com.wei.app.web.controller;

import com.wei.core.domain.bo.SessionMessage;
import com.wei.core.domain.query.SessionMessageQuery;
import com.wei.core.domain.service.ISessionMessageDomainService;
import com.wei.starter.core.push.PushService;
import com.wei.starter.core.push.bo.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("session")
public class SessionController {

    @Resource
    private ISessionMessageDomainService sessionMessageDomainService;

    @Resource
    private PushService pushService;

    @Value("${env:dev}")
    private String env;

    @GetMapping("/list")
    public List<SessionMessage> list(){
        return sessionMessageDomainService.list(SessionMessageQuery.builder().build());
    }

    @GetMapping("/test")
    public String test(){
        return env;
    }

    @GetMapping("send")
    public void sendMessage(@RequestParam("userId") String userId, @RequestParam("dest") String dest, @RequestParam("content") String content){
        Message message = new Message();
        message.setContent(content);
        message.setSeq(UUID.randomUUID().toString());
        pushService.sendToUser(userId, dest, message);
    }

}
