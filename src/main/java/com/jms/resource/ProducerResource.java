package com.jms.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
@RequestMapping("/rest/publish")
public class ProducerResource {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    Queue queue;

    @GetMapping("/{message}")
    public String publish(@PathVariable("message")
                          final String message) {

    	String s = "[\n" + 
    			"                {\n" + 
    			"                    \"id\": \"7426cd91-24d2-4e14-8a1a-82c7f3c2b483\",\n" + 
    			"                    \"name\" : \"Truck 01\",\n" + 
    			"                    \"isOnline\" : true,\n" + 
    			"                    \"pumpStatus\" : \"delivering\",\n" + 
    			"                    \"pumpMode\" : \"Auto\",\n" + 
    			"                    \"inventory\" : 6500,\n" + 
    			"                    \"inventoryPercentage\": 65,\n" + 
    			"                    \"isEnable\": true,\n" + 
    			"                    \"currentLocation\": \"Lot 2345 Lama Ampang, 67000, kula Lumpure, Selangor\",\n" + 
    			"                    \"numberOfPump\": 1,\n" + 
    			"                    \"price\": 2.58,\n" + 
    			"                    \"pumps\": [\n" + 
    			"                        {\n" + 
    			"                            \"name\": \"Nozzle 1\",\n" + 
    			"                            \"activity\": \"Delivering\",\n" + 
    			"                            \"time\": \"3:25 PM\",\n" + 
    			"                            \"delivered\": 3500,\n" + 
    			"                            \"sales\": 9030,\n" + 
    			"                            \"isOnline\": true\n" + 
    			"                        }\n" + 
    			"                    ],\n" + 
    			"                    \"inventoryInfo\": {\n" + 
    			"                        \"initialBalance\" : 10000,\n" + 
    			"                        \"fuelDispensed\": 3500,\n" + 
    			"                        \"currentVolume\": 6500,\n" + 
    			"                        \"tankCapacity\": 10000,\n" + 
    			"                        \"ullage\": 10000,\n" + 
    			"                        \"actualBalance\": 6500,\n" + 
    			"                        \"inventoryPercentage\": 65,\n" + 
    			"                        \"fuelType\": \"Diesel\",\n" + 
    			"                        \"difference\": 0\n" + 
    			"                    }\n" + 
    			"                }\n" + 
    			"]";
    	
        jmsTemplate.convertAndSend(queue, s);

        return "Published Successfully";
    }
}
