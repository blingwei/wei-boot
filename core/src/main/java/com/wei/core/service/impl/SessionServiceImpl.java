package com.wei.core.service.impl;


import com.wei.core.service.SessionService;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {

    @Override
    public void sayHello(){
        System.out.println("hello");
    }

}
