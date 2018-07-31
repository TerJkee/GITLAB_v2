package com.epam.LABSpringBoot.prepare.queues;

import com.epam.LABSpringBoot.prepare.utils.Utils;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class CookSync implements Runnable {

    private SynchronousQueue<String> window;

    public CookSync(SynchronousQueue<String> window) {
        this.window = window;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println("start cooking");
            Utils.sleep(1000 + new Random().nextInt(1000));
            System.out.println("dish is ready, waiting for waiter");

            try {
                window.put("dish");
                System.out.println("Window size: " + window.size());
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
