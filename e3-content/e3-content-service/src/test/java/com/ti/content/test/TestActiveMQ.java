package com.ti.content.test;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class TestActiveMQ {
	@Test
	public void testProducer() throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/*.xml");
		JmsTemplate jmsTemplate = applicationContext.getBean(JmsTemplate.class);
		ActiveMQQueue queue = (ActiveMQQueue) applicationContext.getBean("activeMQqueue");
		jmsTemplate.send(queue , new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage message = session.createTextMessage("its a spring activeMQ queue");
				return message;
			}
		});
		
	}
	@Test
	public void testConsumer() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/*.xml");
		System.in.read();
		
	}

}
