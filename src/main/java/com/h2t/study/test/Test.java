package com.h2t.study.test;

import com.h2t.study.jmx.HtmlAdaptor;
import com.h2t.study.jmx.ThreadPoolParam;
import com.h2t.study.monitor.ThreadPoolMonitor;
import com.h2t.study.util.MBeanServerUtil;

import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.util.Random;
import java.util.concurrent.ExecutorService;

/**
 * @Description: 测试类
 *
 * @Author: hetiantian
 * @Date:2019/10/17 21:29 
 * @Version: 1.0
 */
public class Test {
    private static Random random = new Random();

    public static void main(String[] args) throws MalformedObjectNameException, InterruptedException {
        ExecutorService es1 = ThreadPoolMonitor.newCachedThreadPool("test-pool-1");
        ThreadPoolParam threadPoolParam1 = new ThreadPoolParam(es1);

        ExecutorService es2 = ThreadPoolMonitor.newCachedThreadPool("test-pool-2");
        ThreadPoolParam threadPoolParam2 = new ThreadPoolParam(es2);

        MBeanServerUtil.registerMBean(threadPoolParam1, new ObjectName("test-pool-1:type=threadPoolParam"));
        MBeanServerUtil.registerMBean(threadPoolParam2, new ObjectName("test-pool-2:type=threadPoolParam"));

        //http连接的方式查看监控任务
        HtmlAdaptor.start();

        executeTask(es1);
        executeTask(es2);
        Thread.sleep(1000 * 60 * 60);
    }

    private static void executeTask(ExecutorService es) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                int temp = i;
                es.submit(() -> {
                    //随机睡眠时间
                    try {
                        Thread.sleep(random.nextInt(60) * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(temp);
                });
            }
        }).start();
    }
}
