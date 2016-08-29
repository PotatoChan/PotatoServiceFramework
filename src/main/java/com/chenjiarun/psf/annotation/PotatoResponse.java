package com.chenjiarun.psf.annotation;/**
 * Created by Ives on 16/8/29.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * PotatoServiceFramework
 * 功能：自动进行响应
 * -------------------------------------------------------------------------------------------------
 * 创建者：陈佳润
 * -------------------------------------------------------------------------------------------------
 * 创建日期：2016-08-29  21:52
 * -------------------------------------------------------------------------------------------------
 * 更新历史(日期/更新人/更新内容)
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PotatoResponse {

}
