package mqTest.activeMQ.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class JMSTest {
	private static Logger logger = LoggerFactory.getLogger(JMSTest.class);
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		// ApplicationContext context = new ClassPathXmlApplicationContext(
		// "applicationContext-jms.xml");
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"src/main/java/mqTest/activeMQ/spring/applicationContext-jms.xml");
		JMSConsumer consumer = (JMSConsumer) context.getBean("messageReceiver");
		consumer.recive();
		logger.info("初始化消息消费者");
	}
}
