package com.spring.todolist.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerService {

//    @KafkaListener(topics = "quickstart-events",groupId = "quick-group")
    public void listenEvents(String message) {
        System.out.println("kafka event : " + message);
    }
}
