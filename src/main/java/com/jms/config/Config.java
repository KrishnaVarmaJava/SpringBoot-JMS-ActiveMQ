package com.jms.config;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class Config {

    @Value("${activemq.broker-url}")
    private String brokerUrl;

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("TEST");
    }

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL("ssl://b-77010294-6f95-414a-b729-33a5f87ac4b3-1.mq.us-east-2.amazonaws.com:61617");
        factory.setUserName("admin");
        factory.setPassword("123456789101112");
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
    	JmsTemplate jmsTemplate = new JmsTemplate(activeMQConnectionFactory());
        return jmsTemplate;
    }
    
    
    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
      DefaultJmsListenerContainerFactory factory =
          new DefaultJmsListenerContainerFactory();
      factory
          .setConnectionFactory(activeMQConnectionFactory());
      return factory;
    }
}
