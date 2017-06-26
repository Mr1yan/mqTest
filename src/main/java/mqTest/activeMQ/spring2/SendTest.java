package mqTest.activeMQ.spring2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SendTest {
	private static Logger logger = LoggerFactory.getLogger(SendTest.class);
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		// ApplicationContext context = new ClassPathXmlApplicationContext(
		// "applicationContext-jms.xml");
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"src/main/java/mqTest/activeMQ/spring2/applicationContext-jms.xml");
		Sender sender = (Sender) context.getBean("sender");
		sender.sendInfo();
		logger.info("发送消息");
	}
}
