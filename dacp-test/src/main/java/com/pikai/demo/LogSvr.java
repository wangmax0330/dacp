package com.pikai.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangm on 2017/7/27.
 * /**
 * <p>title: 日志服务器</p>
 * <p>Description: 模拟日志服务器</p>
 * <p>CopyRight: CopyRight (c) 2010</p>
 * <p>Company: 99bill.com</p>
 * <p>Create date: 2010-6-18</P>
 *
 * @author Tank Zhang<tank.zhang@99bill.com>
 * @version v0.1 2010-6-18
 */

public class LogSvr {

    private SimpleDateFormat dateFormat =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 将信息记录到日志文件
     *
     * @param logFile 日志文件
     * @param mesInfo 信息
     * @throws IOException
     */
    public void logMsg(File logFile, String mesInfo) throws IOException {
        if (logFile == null) {
            throw new IllegalStateException("logFile can not be null!");
        }
        Writer txtWriter = new FileWriter(logFile, true);
        txtWriter.write(dateFormat.format(new Date()) + "\t" + mesInfo + "\n");
        txtWriter.flush();
    }

    public static void main(String[] args) throws Exception {

        final LogSvr logSvr = new LogSvr();
        final File tmpLogFile = new File("mock.log");
        if (!tmpLogFile.exists()) {
            tmpLogFile.createNewFile();
        }
        //启动一个线程每5秒钟向日志文件写一次数据
        ScheduledExecutorService exec =
                Executors.newScheduledThreadPool(1);
        exec.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                try {
                    logSvr.logMsg(tmpLogFile, " 99bill test !");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
}