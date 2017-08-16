package com.pikai.consumer;

/**
 * 项目名称：dacp
 * 包名： com.pikai.consumer
 * 类名称：
 * 类描述：消息消费者
 * 创建人:   沃特
 * 创建时间：2017/03/2017/3/23 17:06
 */

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;

public class Consumer {

    /*
    * Constructs a client instance with your account for accessing DefaultMQConsumer
    */
    private static DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("ConsumerGroupName");
    private static int initialState = 0;

    private Consumer() {

    }

    public static DefaultMQPushConsumer getDefaultMQPushConsumer() {
        if (consumer == null) {
            consumer = new DefaultMQPushConsumer("ConsumerGroupName");
        }

        if (initialState == 0) {
            consumer.setNamesrvAddr("192.168.152.131:9876");
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            initialState = 1;
        }

        return consumer;
    }

}