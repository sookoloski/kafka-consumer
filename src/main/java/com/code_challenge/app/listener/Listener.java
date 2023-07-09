package com.code_challenge.app.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class Listener {

    @KafkaListener(topics = "financial-demo", groupId = "test")
    public void handleListener(){

    }
}
