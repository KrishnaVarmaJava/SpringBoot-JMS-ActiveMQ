package com.jms.listener;

import javax.jms.BytesMessage;
import javax.jms.JMSException;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "TEST")
    public void consume(Object message) {
        System.out.println("Received Message: " + message.toString());
        
        if (message instanceof BytesMessage){
        	BytesMessage byteMessage = (BytesMessage) message;
        	byte[] byteData = null;
        	try {
				byteData = new byte[(int) byteMessage.getBodyLength()];
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	try {
				byteMessage.readBytes(byteData);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	try {
				byteMessage.reset();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	String stringMessage =  new String(byteData);
        	System.out.println(stringMessage);
        	}
        
    }
    
    @JmsListener(destination = "TEST")
    public void consume1(Object message) {
        System.out.println("Received Message: " + message.toString());
        
        if (message instanceof BytesMessage){
        	BytesMessage byteMessage = (BytesMessage) message;
        	byte[] byteData = null;
        	try {
				byteData = new byte[(int) byteMessage.getBodyLength()];
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	try {
				byteMessage.readBytes(byteData);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	try {
				byteMessage.reset();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	String stringMessage =  new String(byteData);
        	System.out.println(stringMessage);
        	}
    }
}
