package com.boku.kafka.producer.controller;



import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.LogData;

@RestController
@RequestMapping("v1")
public class KafkaController {

    @Autowired
    private KafkaTemplate<String,LogData> kafkaTemplate;

    private static final String TOPIC = "my-topic";

    @PostMapping(path ="/publish/")
    public String postMessage(@RequestBody LogData logData){
       
        logData.setDateTime(LocalDateTime.now().toString());
        kafkaTemplate.send(TOPIC, logData);

        return "Message Published Successfully";
    }
}
