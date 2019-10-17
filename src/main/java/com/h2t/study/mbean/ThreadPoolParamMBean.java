package com.h2t.study.mbean;

/**
 * @Description: 线程池监控参数MBean接口
 * @Author: hetiantian
 * @Date:2019/10/17 21:33 
 * @Version: 1.0
 */
public interface ThreadPoolParamMBean {
    /**
     * 线程池中正在执行任务的线程数量
     *
     * @return
     */
    int getActiveCount();

    /**
     * 线程池已完成的任务数量
     *
     * @return
     */
    long getCompletedTaskCount();

    /**
     * 线程池的核心线程数量
     *
     * @return
     */
    int getCorePoolSize();

    /**
     * 线程池曾经创建过的最大线程数量。通过这个数据可以知道线程池是否满过，也就是达到了maximumPoolSize
     *
     * @return
     */
    int getLargestPoolSize();

    /**
     * 线程池的最大线程数量
     *
     * @return
     */
    int getMaximumPoolSize();

    /**
     * 线程池当前的线程数量
     *
     * @return
     */
    int getPoolSize();

    /**
     * 线程池已经执行的和未执行的任务总数
     *
     * @return
     */
    long getTaskCount();
}
