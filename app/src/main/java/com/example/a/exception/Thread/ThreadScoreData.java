package com.example.a.exception.Thread;

import java.util.Random;

/**
 * 构建一个客户端提交订单给服务器
 * 服务器  接受客户端的订单提交通常是高并发的业务场景
 * Created by a on 2017/3/30.
 * price 同时被三个线程
 */

public class ThreadScoreData {
    //价格
    private static int price;

    public static void main(String[] args) {
        //多线程环境(模仿高并发)
        for (int i = 0; i < 3; i++) {
            //加了了synchronized不行，
            //锁的对象不是一个，三个线程看到的锁不是同一个

            /*new Thread(new Runnable() {
                @Override
                public synchronized void run() {
                    //执行业务方法   去淘宝买东西，提交订单，价格显示出来，不能超过1万，订单要查询的信息有很多，需要很多模块出来订单，其中
                    //重要的是价格，我买个很贵重的东西价格串了，所有在这里模拟A、B模块
                    price = new Random().nextInt(10000);//上限10000
                    System.out.println("产出线程名称：" + Thread.currentThread().getName() + ",价格为：" + price);
                    //进入A处理模块，
                    new A().getPriceInfo();

                    //进入B处理模块
                    new B().getPriceInfo();
                }
            }).start();*/
            new Thread(new Runnable() {
                //每个线程看到的锁都是不一样的
                @Override
                public  void run() {
                    synchronized (ThreadScoreData.class){
                    //执行业务方法   去淘宝买东西，提交订单，价格显示出来，不能超过1万，订单要查询的信息有很多，需要很多模块出来订单，其中重要的是价格，我买个很贵重的东西价格串了，所有在这里模拟A、B模块
                    price = new Random().nextInt(10000);//上限10000
                    System.out.println("产出线程名称：" + Thread.currentThread().getName() + ",价格为：" + price);
                    //进入A处理模块，
                    new A().getPriceInfo();
                    //进入B处理模块
                    new B().getPriceInfo();
                    }
                }
            }).start();
        }


    }

    //服务器中的A模块，检查余额是否可以支付
    static class A {
        public void getPriceInfo() {
            System.out.println(Thread.currentThread().getName() + "进入A模块，处理价格信息是" + price);
        }
    }

    //服务器中的A模块，检查余额是否可以支付
    static class B {
        public void getPriceInfo() {
            System.out.println(Thread.currentThread().getName() + "进入B模块，处理价格信息是" + price);
        }
    }
}
