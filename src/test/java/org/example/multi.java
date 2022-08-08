package org.example;

public class multi extends Thread {
    public static void main(String[] args) {
        multi t1 = new multi();
        Thread t = new Thread("This is thread test");
        t1.start();
        t.start();
        String str = t.getName();
        System.out.println(str);
    }

    public void run() {
        System.out.println("thread is running...");
    }
}
