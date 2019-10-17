package com.spring.demo.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

/*
    MQ 生产消息类
 */
public class MQserver {
    public static void main(String[] args) throws Exception {
        String brokerUrl = "tcp://10.73.240.69:61616";
        Connection connection = null;
        Session session = null;
        try {
        // 创建一个连接工厂
        ConnectionFactory factory = new ActiveMQConnectionFactory(brokerUrl);
        // 创建连接对象并启动
        connection = factory.createConnection();
        connection.start();// 注意：事故多发地！！！
        // 创建会话对象
        // Boolean.TRUE 把生产者正产的所有消息当做一个事务来处理
        session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        // 创建生产者生产消息的存储地方
        Destination destination = new ActiveMQQueue("MQ-QUEUE");
        // 创建生产者
        MessageProducer messageProducer = session.createProducer(destination);
        for (int i = 0; i < 3; i++) {
            // 创建一个待发送消息
            TextMessage textMessage = session.createTextMessage("消息生产者"+(i+1));
            // 生产者将消息发送到指定目的地
            messageProducer.send(textMessage);
        }
        // 提交事务
        session.commit();
        }catch (Exception E) {
            // 关闭session
            if(session != null){
                session.close();
            }
            // 关闭连接
            if (connection != null){
                connection.close();
            }
        }
    }
}
