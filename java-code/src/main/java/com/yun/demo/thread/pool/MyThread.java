package com.yun.demo.thread.pool;
/**
 * @author yun
 */
public class MyThread extends AbstractMyTask {

    @Override
    public void task() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print("打完了");
    }
}