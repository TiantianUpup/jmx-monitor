package com.h2t.study.jmx.adaptor;

import com.h2t.study.jmx.server.MBeanServerUtil;
import com.sun.jdmk.comm.HtmlAdaptorServer;

import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

/**
 * HtmlAdaptorServer封装类，提供HTTP连接查看方式
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/10/19 13:06
 */
public class HtmlAdaptor {
    /**
     * HTTP连接端口号
     */
    private static final String PORT = "8082";
    private static HtmlAdaptorServer adapter = new HtmlAdaptorServer();

    public static void start() {
        try {
            MBeanServerUtil.registerMBean(adapter, new ObjectName(String.format("HtmlAgent:name=html-adapter, port=%s", PORT)));
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        }
        adapter.start();
    }
}
