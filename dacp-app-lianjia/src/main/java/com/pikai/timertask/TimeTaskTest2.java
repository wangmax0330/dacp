package com.pikai.timertask;
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
public class TimeTaskTest2 {

    static class TimerTaskTest extends TimerTask {
        public void run() {
            System.out.println("线程1爆炸！！！");
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTaskTest(), 1000, 2000);
    }
}
