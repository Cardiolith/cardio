package com.tcaini.cardio.quartz.util;

import org.springframework.scheduling.quartz.QuartzJobBean;

public class JobUtil {

    public static QuartzJobBean getClass(String className) throws Exception{
        Class<?> clazz = Class.forName(className);
        return (QuartzJobBean)clazz.newInstance();
    }
}
