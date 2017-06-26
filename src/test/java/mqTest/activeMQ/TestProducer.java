package mqTest.activeMQ;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import mqTest.BaseJunit4Test;
import mqTest.activeMQ.spring2.ReceiverTest;
import mqTest.activeMQ.spring3.Producer;

public class TestProducer extends BaseJunit4Test {
	private static Logger logger = LoggerFactory.getLogger(ReceiverTest.class);
	@Autowired
	private Producer producer;
	@Test
	public void send() {
		this.producer.sendMessage("the message come from Spring!");
		logger.info("发送消息。。。。。。");
	}
}
