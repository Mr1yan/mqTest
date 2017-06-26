package mqTest.activeMQ.spring;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class HelloSender {
	/**
	 * jmsTemplate和destination都是在spring配置文件中进行配制的
	 * Sender只使用了配置文件中的jmsFactory，jmsTemplate，还有destination这三个属性
	 */
	private static Logger logger = LoggerFactory.getLogger(HelloSender.class);
	public static void main(String[] args) {
		// 路径问题：http://www.blogjava.net/xcp/archive/2011/06/22/352821.html
		@SuppressWarnings("resource")
		// ApplicationContext context = new ClassPathXmlApplicationContext(
		// "applicationContext-jms.xml");
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"src/main/java/mqTest/activeMQ/spring/applicationContext-jms.xml");
		JmsTemplate template = (JmsTemplate) context.getBean("jmsTemplate");
		Destination destination = (Destination) context.getBean("destination");
		template.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session
						.createTextMessage("发送消息：Hello ActiveMQ Text Message");
			}
		});
		logger.info("成功发送了一条JMS消息");

	}

}
