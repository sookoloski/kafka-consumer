package com.code_challenge.app.listener;

import com.code_challenge.app.handler.HandlerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class Listener {

    private final HandlerService handlerService;

    public Listener(HandlerService handlerService) {
        this.handlerService = handlerService;
    }

    @KafkaListener(topics = "financial-demo", groupId = "test")
    public void handleListener(@Payload String message){

        try{

            var splitMessage = message.split(",",2);
            handlerService.handleReceivedValues(splitMessage[0],  splitMessage[1]);
            log.info("[Listener] Received message {} from type {}", splitMessage[1], splitMessage[0]);

        } catch (Exception ex){

            log.info("[Listener] Error while listening topics {} errmsg: {} trace {}", message,
                    ex.getMessage(), ex.getStackTrace());
        }
    }
}
