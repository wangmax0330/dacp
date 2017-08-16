package com.pikai.producer;

/**
 * 项目名称：dacp
 * 包名： com.pikai.prode
 * 类名称：
 * 类描述：消息生产者
 * 创建人:   沃特
 * 创建时间：2017/03/2017/3/23 17:04
 */


import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;

public class Producer {

    /*
    * Constructs a client instance with your account for accessing DefaultMQProducer
    */
    private static DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");
    private static int initialState = 0;

    private Producer() {

    }

    public static DefaultMQProducer getDefaultMQProducer() {
        if (producer == null) {
            producer = new DefaultMQProducer("ProducerGroupName");
        }

        if (initialState == 0) {
            producer.setNamesrvAddr("192.168.152.131:9876");
            try {
                producer.start();
            } catch (MQClientException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }

            initialState = 1;
        }

        return producer;
    }

}
