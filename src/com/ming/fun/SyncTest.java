package com.ming.fun;

import java.util.concurrent.TimeUnit;

//sync 在进入同步代码块（获取sync锁）前，将清空工作内存中共享变量的值，从而使用共享变量时需要从主内存中重新读取最新的值
//线程解锁前，必须把共享变量的最新值刷新到主内存中
//程序：在加了syn之后，线程会看到i的变化，然后break，就算i不在syn代码块里也可以

//！！！！奇怪的一点：
//在syn代码块退出之后，仍然保持了可见性。这就搞不懂了，莫非只要这个线程里有syn，该线程就一直拥有可见性了吗？
//
public class SyncTest {
    public static int i;
    public static void main(String[] args) throws Exception {
        Object o = new Object();
        new Thread(() -> {             //线程A
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i = 1;
            while (true) {
            }
        }).start();
        new Thread(() -> {            //线程B
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            synchronized (o) {//加了这个同步代码块后线程B就能马上停止，里面什么都不写
                System.out.println("exit sync");
            }
            while (true) {

                //System.out.println("before sync : " + i);
//                synchronized (o) {   //加了这个同步代码块后线程B就能马上停止，里面什么都不写
//                }
                //synchronized (o) {
                System.out.println(i);
                    if (i == 1) {
                        System.out.println("结束");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("out");
                        break;
                    }
                //}
            }
        }).start();
        Thread.sleep(1000);
        new Thread(() -> {
            //synchronized (o) {
                //while (true){
                i = 2;
                System.out.println("i=" + i);
                //}
            //}
        }).start();

        Thread.sleep(2000);
        new Thread(() -> {
            //synchronized (o) {
            //while (true){
            i = 3;
            System.out.println("i=" + i);
            //}
            //}
        }).start();
        Thread.sleep(2000);
        new Thread(() -> {
            //synchronized (o) {
            //while (true){
            i = 1;
            System.out.println("i=" + i);
            //}
            //}
        }).start();
        
    }
}
