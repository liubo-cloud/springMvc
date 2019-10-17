package com.spring.demo.test;

/**
 * 线程-模拟铁路售票-并发
 */
public class Ticket implements Runnable {
    private int num;//票数量
    private boolean flag = true;//若为false则售票停止

    // 构造方法、初始化成员变量
    public Ticket (int num){
        this.num = num;
    }

    public void run(){
        // 是否还有票
        while(flag){
            ticket();
        }
    }
    // 售票方法
    private synchronized void ticket(){
        if(num <= 0){
            flag = false;
            return;
        }
        try{
            Thread.sleep(20);//模拟延时操作
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        //当前窗口号以及出票序列号
        System.out.println(Thread.currentThread().getName()+"售出票序列号："+num--);
    }

    public static void main(String[] args) {
        Ticket ticket = new Ticket(5);// 票数
        Thread window01 = new Thread(ticket,"窗口01");//线程01
        Thread window02 = new Thread(ticket,"窗口02");//线程02
        Thread window03 = new Thread(ticket,"窗口03");//线程03
        window01.start();
        window02.start();
        window03.start();
    }
}

