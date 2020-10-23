package com.practice.learning.threads;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

    private static Object lock = new Object();

    static List<Integer> buffer = new ArrayList<>();
    public static int count=0;


    public static class Producer{
        public void produce(){
            synchronized(lock) {
                if(ifFull()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count++;
                buffer.add(1);
                lock.notify();
            }
        }
    }


    public static class Consumer{
        public void consume(){
            synchronized (lock) {
                if (isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                buffer.set(count-1, 0);
                count--;
                lock.notify();
            }
        }
    }

    static boolean ifFull(){
        return count==10;
    }

    static boolean isEmpty(){
        return count==0;
    }
}
