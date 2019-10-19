package com.h2t.study.util;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * MBeanServer工具类
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/10/19 12:56
 */
public class MBeanServerUtil {
    private static MBeanServer server = ManagementFactory.getPlatformMBeanServer();

    public static void registerMBean(Object obj, ObjectName objectName) {
        try {
            server.registerMBean(obj, objectName);
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        } catch (MBeanRegistrationException e) {
            e.printStackTrace();
        } catch (NotCompliantMBeanException e) {
            e.printStackTrace();
        }
    }
}
