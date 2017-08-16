package com.pikai.service;

/**
 * 项目名称：dacp
 * 包名： com.pikai.service
 * 类名称：
 * 类描述：
 * 创建人:   沃特
 * 创建时间：2017/03/2017/3/23 17:09
 */

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RocketMQSentMsgDemo {

    private static final Logger logger = LoggerFactory.getLogger(RocketMQSentMsgDemo.class);

    public static void main(String[] args) {
        sendMsg();
    }

    public static void sendMsg() {

        // 获取消息生产者
        DefaultMQProducer producer = com.pikai.producer.Producer.getDefaultMQProducer();

        try {
            for (int i = 0; i < 2000; i++) {
                Message msg = new Message(
                        "TopicTest1",                   // topic
                        "TagA",                         // tag
                        "OrderID00" + i,                  // key
                        ("Hello MetaQ" + i).getBytes());  // body
                SendResult sendResult = producer.send(msg);
                logger.info("++++++++++++++++++++++++++++++++++++++++sendResult:{}", sendResult);
            }
        } catch (MQClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemotingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MQBrokerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        producer.shutdown();
    }
}