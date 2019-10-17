package com.h2t.study;

import com.h2t.study.mbean.ThreadPoolParam;
import com.h2t.study.monitor.ThreadPoolMonitor;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.concurrent.ExecutorService;

/**
 * @Description: 测试类
 *
 * @Author: hetiantian
 * @Date:2019/10/17 21:29 
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        ExecutorService es = ThreadPoolMonitor.newCachedThreadPool("test-pool");
        ThreadPoolParam threadPoolParam = new ThreadPoolParam(es);
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        server.registerMBean(threadPoolParam, new ObjectName("test-jmx:type=threadPoolParam"));

        for (int i = 0; i < 100; i++) {
            int temp = i;
            Thread.sleep(3000);
            es.submit(() -> System.out.println(temp));
        }

        Thread.sleep(1000 * 60 * 60);
    }
}
