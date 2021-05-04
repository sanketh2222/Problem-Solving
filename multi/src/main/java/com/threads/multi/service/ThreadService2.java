package com.threads.multi.service;

// package com.threads.multi.service;

import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ThreadService2 implements Runnable {
    static int counter = 1;

    private volatile boolean isOdd;

    static int counter2 = 1;

    static ReentrantLock counterLock = new ReentrantLock(true); // gurantes sync between the 2 threads

    public static Logger logger = LoggerFactory.getLogger(ThreadService.class);

    static void incrementCounter() {
        counterLock.lock();

        // Always good practice to enclose locks in a try-finally block
        try {
            logger.info("CURRENT THREAD :" + Thread.currentThread().getName() + ": " + counter);
            counter++;
        } finally {
            counterLock.unlock();
        }
    }

    synchronized void incrementCounter1() {

        // /Not in-sync as of now
        while (counter2 <= 20) {
            try {
                System.out.println(Thread.currentThread().getName() + ": " + counter2);
                counter2++;
                isOdd = true;
                if (isOdd){
                    notify();
                }
                wait();
               

            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }

            notify();

        }

        // }
    }

    synchronized void incrementCounter2() {

        // /Not in-sync as of now
        while (counter2 <= 20) {
            try {

                System.out.println(Thread.currentThread().getName() + ": " + counter2);
                counter2++;
                isOdd = false;
                if (isOdd){
                    wait();
                    isOdd=true;
                }
                
                

            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }

            notify();

        }

        // }
    }

    @Override
    public void run() {
        while (counter <= 20) {
            incrementCounter1();
            incrementCounter2();
            // incrementCounter(); //not working as expected need to check this
        }
    }

    public static void main(String[] args) {
        ThreadService2 te = new ThreadService2();
        Thread thread1 = new Thread(te);
        Thread thread2 = new Thread(te);

        thread1.start();
        // thread1.wait();
        thread2.start();

    }
}
