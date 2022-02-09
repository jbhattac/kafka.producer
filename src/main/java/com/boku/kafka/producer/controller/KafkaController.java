package com.boku.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boku.kafka.producer.model.User;

@RestController
@RequestMapping("v1")
public class KafkaController {

    @Autowired
    private KafkaTemplate<String,User> kafkaTemplate;

    private static final String TOPIC = "my-topic";

    @GetMapping("/publish/{name}")
    public String postMessage(@PathVariable("name") final String name){
        User user = new User();
        user.setName(name);
        user.setDepartment("Technology");
        user.setSalary(4000000L);
        kafkaTemplate.send(TOPIC, user);

        return "Message Published Successfully";
    }
}
