package mqTest.activeMQ.spring;
import javax.jms.Destination;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
/**
 * JMS消费者 消息题的内容定义 消息对象 接收消息对象后： 接收到的消息体*
 * <p>
 */
public class JMSConsumer {
	private static Logger logger = LoggerFactory.getLogger(JMSConsumer.class);
	public JMSConsumer() {

	}
	private JmsTemplate jmsTemplate;
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	/**
	 * 监听到消息目的有消息后自动调用onMessage(Message message)方法
	 */
	public void recive() {
		@SuppressWarnings("resource")
		// ApplicationContext context = new ClassPathXmlApplicationContext(
		// "applicationContext-jms.xml");
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"src/main/java/mqTest/activeMQ/spring/applicationContext-jms.xml");
		Destination destination = (Destination) context.getBean("destination");
		while (true) {
			try {
				TextMessage msg = (TextMessage) jmsTemplate
						.receive(destination);
				if (null != msg) {
					logger.info("message:" + msg);
					logger.info("收到消息内容:" + msg.getText());
				} else {
					break;
				}
			} catch (Exception e) {
				logger.error("zzz", e);
			}
		}
	}
}
