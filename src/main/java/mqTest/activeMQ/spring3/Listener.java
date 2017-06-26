package mqTest.activeMQ.spring3;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.listener.SessionAwareMessageListener;

import mqTest.activeMQ.spring2.ReceiverTest;

public class Listener implements SessionAwareMessageListener<Message> {
	private static Logger logger = LoggerFactory.getLogger(ReceiverTest.class);
	public void onMessage(Message msg, Session session) throws JMSException {
		if (msg instanceof TextMessage) {
			logger.info("消费者获得消息:{}", ((TextMessage) msg).getText());
		}
	}

}
