package com.chenjiarun.psf.context;/**
 * Created by Ives on 16/8/29.
 */

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * psf
 * 功能：
 * -------------------------------------------------------------------------------------------------
 * 创建者：陈佳润
 * -------------------------------------------------------------------------------------------------
 * 创建日期：2016-08-29  23:17
 * -------------------------------------------------------------------------------------------------
 * 更新历史(日期/更新人/更新内容)
 */
public class PotatoSpringAppContext implements ApplicationContextAware {

    private static ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        PotatoSpringAppContext.applicationContext = applicationContext;
    }

    /**
     * 根据bean名字获取bean
     *
     * @param beanName bean名字
     * @return
     */
    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }

    /**
     * 根据bean名字判断是否存在该bean
     *
     * @param beanName bean名字
     * @return
     */
    public static boolean isExist(String beanName) {
        return applicationContext.containsBean(beanName);
    }

}
