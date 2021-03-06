package com.epam.LABSpringBoot.prepare;

import com.epam.LABSpringBoot.prepare.utils.Utils;

// Mutex, ctitical section in the static method, acquire lock in the same thread (Mutex knows who locked it)
public class AppMutexCriticalSectionStatic {

    private static int counter = 0;
//
//    public static void change() {
//        synchronized (AppMutexCriticalSectionStatic.class) {
//            counter++;
//        }
//        System.out.println("counter = " + counter);
//    }

    private static final Object object = new Object();
    public static void change() {
        synchronized (object) {
            setChange(1);
            counter = 3;
        }
        System.out.println("counter = " + counter);
    }

    public static void setChange(int _counter) {
        synchronized (object) {
            counter = _counter;
        }
    }


    public static void main(String... args) {
        new Thread(() -> {
            change();
        }).start();

        setChange(2);

        Utils.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " exited");
    }
}
