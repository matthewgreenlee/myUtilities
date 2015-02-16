package com.goldenpond.thread;

import com.goldenpond.utils.Print;

public class InterruptExample {

    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new Interrupted());
        t.start();
        Thread.sleep(100);
        t.interrupt();
        Print.ln("main thread is done");
    }

}

class Interrupted implements Runnable {

    public void run() {
        // check interrupt status regularly, or the thread will go on execution
        while (!Thread.interrupted()) {
            Print.ln("new thread is running");
        }
    }
    
}