/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package leetcode.editor.com.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author adomyzhao
 * @version $Id: WaitNotifyTest.java, v 0.1 2022-02-16 15:24 adomyzhao Exp $$
 */
public class WaitNotifyTest {

    private Object object = new Object();

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        WaitNotifyTest test = new WaitNotifyTest();
        executorService.submit(test::waitOutter);
        executorService.submit(test::notifyOutter);
    }

    public void waitOutter() {

        synchronized (this.object) {
            try {
                this.object.wait();

                System.out.println("hello world, " + Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void notifyOutter() {
        synchronized (this.object) {
            try {
                System.out.println("notify");

                this.object.notify();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}