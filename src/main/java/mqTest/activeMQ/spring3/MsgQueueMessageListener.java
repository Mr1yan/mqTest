package mqTest.activeMQ.spring3;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.listener.SessionAwareMessageListener;

public class MsgQueueMessageListener
		implements
			SessionAwareMessageListener<Message> {

	public void onMessage(Message arg0, Session arg1) throws JMSException {
		// TODO Auto-generated method stub

	}

}
