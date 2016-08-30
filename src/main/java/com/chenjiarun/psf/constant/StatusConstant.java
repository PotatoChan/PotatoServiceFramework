package com.chenjiarun.psf.constant;/**
 * Created by Ives on 16/8/29.
 */

import com.chenjiarun.psf.model.StatusPair;

/**
 * psf
 * 功能：
 * -------------------------------------------------------------------------------------------------
 * 创建者：陈佳润
 * -------------------------------------------------------------------------------------------------
 * 创建日期：2016-08-29  23:08
 * -------------------------------------------------------------------------------------------------
 * 更新历史(日期/更新人/更新内容)
 */
public class StatusConstant {


    public static final StatusPair SUCCESS = new StatusPair(200, "请求成功");

    public static final StatusPair ERROR_JSON_RESOLVE = new StatusPair(801, "JSON解析出错");

    public static final StatusPair ERROR_MD5 = new StatusPair(802, "MD5加密出错");

    public static final StatusPair ERROR_SYSTEM_UNKNOW = new StatusPair(803, "系统未知错误");


}
