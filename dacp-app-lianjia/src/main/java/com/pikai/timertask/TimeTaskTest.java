package com.pikai.timertask;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 项目名称：dacp
 * 包名： com.pikai.timertask
 * 类名称：
 * 类描述：
 * 创建人:   沃特
 * 创建时间：2017/05/2017/5/10 11:47
 */
public class TimeTaskTest {

    static class MyTimerTask1 extends TimerTask {
        public void run() {
            System.out.println("线程1爆炸！！！");
            new Timer().schedule(new MyTimerTask2(), 2000);
        }
    }

    static class MyTimerTask2 extends TimerTask {
        public void run() {
            System.out.println("线程2爆炸！！！");
            new Timer().schedule(new MyTimerTask1(), 3000);
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTimerTask2(), 2000);
        while (true) {
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
