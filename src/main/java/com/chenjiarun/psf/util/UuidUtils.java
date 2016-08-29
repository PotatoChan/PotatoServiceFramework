package com.chenjiarun.psf.util;/**
 * Created by Ives on 16/8/29.
 */

import java.util.UUID;

/**
 * PotatoServiceFramework
 * 功能：UUID工具类
 * -------------------------------------------------------------------------------------------------
 * 创建者：陈佳润
 * -------------------------------------------------------------------------------------------------
 * 创建日期：2016-08-29  21:59
 * -------------------------------------------------------------------------------------------------
 * 更新历史(日期/更新人/更新内容)
 */
public class UuidUtils {

    /**
     * @return String 带"-"的uuid
     */
    public static String generate() {
        return UUID.randomUUID().toString();
    }


    /**
     * @return String 不带"-"的uuid
     */
    public static String generateWithLine() {
        return UUID.randomUUID().toString().replace("-", "");
    }


}
