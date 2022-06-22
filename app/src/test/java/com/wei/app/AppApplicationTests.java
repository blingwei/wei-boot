package com.wei.app;

import com.wei.core.domain.bo.SessionMessage;
import com.wei.core.domain.query.SessionMessageQuery;
import com.wei.core.domain.service.ISessionMessageDomainService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class AppApplicationTests {

    @Resource
    private ISessionMessageDomainService sessionMessageDomainService;

    @Test
    void contextLoads() {
    }

    @Test
    void testDomain(){
        List<SessionMessage> sessionMessageList = sessionMessageDomainService.list(SessionMessageQuery.builder().build());
        System.out.println(sessionMessageList);
    }

}
