import activemqtest.Application;
import activemqtest.domain.Message;
import activemqtest.producers.TopicProducer;
import org.junit.runner.RunWith;
import javax.jms.JMSException;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.*;

/**
 * Created by zotova on 06.07.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ActiveMQTopicTest {

    @Autowired
    private TopicProducer producer;

    @Test
    public void sendSimpleMessageTest() throws InterruptedException, JMSException {

        try {
            Message m = new Message();
            m.setDestinationQueueName("A");
            m.setMessageId(1);
            m.setMessageText("Hello world!");
            this.producer.sendMessage(m);
        }
        catch (Exception ex) {

        }
        //Thread.sleep(1000L);
        // assertThat(this.outputCapture.toString().contains("Test message")).isTrue();
    }

}
