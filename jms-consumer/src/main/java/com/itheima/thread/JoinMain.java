package com.itheima.thread;

/**
 * thread.Join把指定的线程加入到当前线程，可以将两个交替执行的线程合并为顺序执行的线程。
 * 比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B 
 */
public class JoinMain {

    public static void main(String[] args) {

        final Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("t1 begin");
            }
        },"t1");

        final Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    thread1.join(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2 begin");
            }
        },"t2");

        Thread thread3 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    thread2.join(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t3 begin");
            }
        },"t3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
