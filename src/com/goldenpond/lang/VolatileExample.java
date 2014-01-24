package com.goldenpond.lang;

class VolatileExample {
    // volatile was necessary, or thread2 won't see the change made by thread1
    volatile boolean flag = false;

    private void write() {
        System.out.println(Thread.currentThread().getName() + " was changing flag");
        flag = true;
    }

    private void read() {
        // busy wait until flag was changed
        while (!flag) {
        }
        System.out.println(Thread.currentThread().getName() + " saw the flag change");
    }

    public static void main(String[] args) throws Exception {
        final VolatileExample example = new VolatileExample();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                // let thread2 go first
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {}
                example.write();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                example.read();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}