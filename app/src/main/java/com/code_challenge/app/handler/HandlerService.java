package com.code_challenge.app.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
@Slf4j
public class HandlerService {

    private final Map<String, String> mapper = new HashMap<>();

    public void handleReceivedValues( String type, String message){

        /*
        * Next steps would be verifying if type already exists then updating its value
        * if not, add it and set the current value as the one sent by Listener class
         */
        if(!message.isEmpty()){
            mapper.put(type,message);
            mapper.get(type);

            log.info("[HandlerService] Received message {} from type {}", message, type);
        }
    }
}
