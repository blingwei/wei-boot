package com.wei.rpc.impl;

import com.wei.rpc.api.SessionApi;
//import org.apache.dubbo.config.annotation.Service;

//@Service
public class SessionApiImpl implements SessionApi {

    @Override
    public String sayHello() {
        System.out.println("test hello");
        return "hello";
    }
}
