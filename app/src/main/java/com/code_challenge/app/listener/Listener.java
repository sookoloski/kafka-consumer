package com.code_challenge.app.listener;

import com.code_challenge.app.handler.HandlerService;

import java.util.logging.Logger;

import java.util.logging.Level;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class Listener {

    private final HandlerService handlerService;

    public Listener(HandlerService handlerService) {
        this.handlerService = handlerService;
    }

    @KafkaListener(topics = "financial-demo", groupId = "test")
    public void handleListener(@Payload String message,
                               @Header("type") String type){

        Logger logger
                = Logger.getLogger(
                Listener.class.getName());

        try{

            handlerService.handleReceivedValues(type, message);
            logger.log(Level.INFO,"Received message {0} from {1} ", new Object[]{ message, type });

        } catch (Exception ex){

            logger.log(Level.SEVERE,"Error while listening {0} trace {1}", new Object[] {ex.getMessage(), ex.getStackTrace()});

        }
    }
}
