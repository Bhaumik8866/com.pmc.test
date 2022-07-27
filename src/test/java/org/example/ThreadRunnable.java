package org.example;

public class ThreadRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("thread is running...");
    }

    public static void main(String[] args)
    {
        ThreadRunnable m1=new ThreadRunnable();
        Thread t1=new Thread(m1);
        t1.start();
    }
}
