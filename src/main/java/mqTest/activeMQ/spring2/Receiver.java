package mqTest.activeMQ.spring2;
import javax.jms.MapMessage;

import org.springframework.jms.core.JmsTemplate;

public class Receiver {
	public Receiver() {

	}
	private JmsTemplate jmsTemplate;
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public String recive() throws Exception {
		String txt = "";
		MapMessage msg = (MapMessage) jmsTemplate.receive();
		try {
			txt = msg.getString("lastName");
		} catch (Exception e) {
			throw e;
		}
		return txt;
	}
}
