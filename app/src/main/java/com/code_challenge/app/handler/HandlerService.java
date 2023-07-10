package com.code_challenge.app.handler;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service

public class HandlerService {

    private final Map<String, String> mapper = new HashMap<>();

    public void handleReceivedValues(String type, String message){

        if(!message.isEmpty()){
            mapper.put(type, message);
            mapper.get(type);

        }
    }
}
