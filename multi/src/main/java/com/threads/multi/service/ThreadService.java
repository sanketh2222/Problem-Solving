package com.threads.multi.service;

import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ThreadService implements Runnable {
    static int counter = 1; // a global counter

    static ReentrantLock counterLock = new ReentrantLock(true); // enable fairness policy

    public static Logger logger = LoggerFactory.getLogger(ThreadService.class);

    public void incrementCounter(){
        counterLock.lock();

        // Always good practice to enclose locks in a try-finally block
        try{
            logger.info("CURRENT THREAD :"+Thread.currentThread().getName() + ": " + counter);
            counter++;
        }finally{
             counterLock.unlock();
        }
     }

    @Override
    public void run() {
        while(counter<=20){
            incrementCounter();
        }
    }

    public static void main(String[] args) {
        ThreadService te = new ThreadService();
        Thread thread1 = new Thread(te);
        Thread thread2 = new Thread(te);

        thread1.start();
        thread2.start();          
    }
}
