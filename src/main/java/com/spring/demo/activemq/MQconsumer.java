package com.spring.demo.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import javax.jms.*;

/*
    MQ 消费消息类
 */
public class MQconsumer {
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
            // Boolean.TRUE 把生产所有的操作当做一个事务来处理
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            // 创建生产者生产消息的存储地方
            Destination destination = new ActiveMQQueue("MQ-QUEUE");
            // 创建生产者
            MessageConsumer messageConsumer = session.createConsumer(destination);
            for (int i = 0; i < 3; i++) {
                // 接收消息
                Message message = messageConsumer.receive();
                // 判断消息类型
                if (message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    System.out.println(textMessage.getText());
                }
            }
            // 提交事务
            session.commit();
        }catch (Exception E) {
            // 关闭session
            if (session != null) {
                session.close();
            }
            // 关闭连接
            if (connection != null) {
                connection.close();
            }
        }
    }
}
