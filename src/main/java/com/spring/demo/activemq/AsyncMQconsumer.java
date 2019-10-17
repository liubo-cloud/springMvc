package com.spring.demo.activemq;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

/*
    MQ 消费消息类-异步消费
 */
public class AsyncMQconsumer {
    public static void main(String[] args) throws Exception {
        String brokerUrl = "tcp://127.0.0.1:8080";
        Connection connection = null;
        Session session = null;
        try {
            // 创建一个连接工厂
            ConnectionFactory factory = new ActiveMQConnectionFactory(brokerUrl);
            // 创建连接对象并启动
            connection = factory.createConnection();
            connection.start();// 注意：事故多发地！！！
            // 创建会话对象
            // Boolean.TRUE  把生产所有的操作当做一个事务来处理
            // Boolean.FALSE 异步处理
            session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
            // 创建生产者生产消息的存储地方
            Destination destination = new ActiveMQQueue("MQ-QUEUE");
            // 创建消费者
            MessageConsumer messageConsumer = session.createConsumer(destination);
            // 消费者监听
            messageConsumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    if (message instanceof TextMessage) {
                        TextMessage textMessage = (TextMessage) message;
                        try {
                            System.out.println(textMessage.getText());
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            // 提交事务
            session.commit();
        }catch (Exception E) {
            // 关闭session
            if(session != null) {
                session.close();
            }
            // 关闭连接
            if (connection != null){
                connection.close();
            }
        }
    }
}
