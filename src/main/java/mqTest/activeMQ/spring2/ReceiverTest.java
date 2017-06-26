package mqTest.activeMQ.spring2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ReceiverTest {
	private static Logger logger = LoggerFactory.getLogger(ReceiverTest.class);
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		// ApplicationContext context = new ClassPathXmlApplicationContext(
		// "applicationContext-jms.xml");
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"src/main/java/mqTest/activeMQ/spring2/applicationContext-jms.xml");
		Receiver receiver = (Receiver) context.getBean("receiver");
		logger.info("收到消息：" + receiver.recive());
	}
}
