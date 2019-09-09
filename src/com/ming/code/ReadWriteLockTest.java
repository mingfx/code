package com.ming.code;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest extends Thread{
    public  static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
    public boolean flag;

    public ReadWriteLockTest(boolean flag) {
        this.flag = flag;
    }

    public void run() {
        if(flag){

            readLock.lock();
            try{
                System.out.println(Thread.currentThread().getName() + "获取了读锁");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "释放读锁");
            readLock.unlock();
        }else{

            writeLock.lock();
            try{

                System.out.println(Thread.currentThread().getName() + "获取了写锁");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "释放写锁");
            writeLock.unlock();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockTest thread0 = new ReadWriteLockTest(true);
        ReadWriteLockTest thread1 = new ReadWriteLockTest(false);
        ReadWriteLockTest thread2 = new ReadWriteLockTest(true);

        ReadWriteLockTest thread3 = new ReadWriteLockTest(true);
        thread0.start();
        Thread.sleep(2000);

        thread1.start();
        thread2.start();
        thread3.start();



    }
}
