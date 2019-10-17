package com.h2t.study.mbean;

import com.h2t.study.monitor.ThreadPoolMonitor;

import java.util.concurrent.ExecutorService;

/**
 * @Description: MBean接口实现类
 *
 * @Author: hetiantian
 * @Date:2019/10/17 21:32 
 * @Version: 1.0
 */
public class ThreadPoolParam implements ThreadPoolParamMBean  {
    private ThreadPoolMonitor threadPoolMonitor;

    public ThreadPoolParam(ExecutorService es) {
        this.threadPoolMonitor = (ThreadPoolMonitor) es;
    }

    /**
     * 线程池中正在执行任务的线程数量
     *
     * @return
     */
    @Override
    public int getActiveCount() {
        return threadPoolMonitor.getAc();
    }

    /**
     * 线程池已完成的任务数量
     *
     * @return
     */
    @Override
    public long getCompletedTaskCount() {
        return threadPoolMonitor.getCompletedTaskCount();
    }

    /**
     * 线程池的核心线程数量
     *
     * @return
     */
    @Override
    public int getCorePoolSize() {
        return threadPoolMonitor.getCorePoolSize();
    }

    /**
     * 线程池曾经创建过的最大线程数量。通过这个数据可以知道线程池是否满过，也就是达到了maximumPoolSize
     *
     * @return
     */
    @Override
    public int getLargestPoolSize() {
        return threadPoolMonitor.getLargestPoolSize();
    }

    /**
     * 线程池的最大线程数量
     *
     * @return
     */
    @Override
    public int getMaximumPoolSize() {
        return threadPoolMonitor.getMaximumPoolSize();
    }

    /**
     * 线程池当前的线程数量
     *
     * @return
     */
    @Override
    public int getPoolSize() {
        return threadPoolMonitor.getPoolSize();
    }

    /**
     * 线程池已经执行的和未执行的任务总数
     *
     * @return
     */
     @Override
    public long getTaskCount() {
        return threadPoolMonitor.getTaskCount();
    }
}
