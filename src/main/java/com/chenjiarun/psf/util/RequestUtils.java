package com.chenjiarun.psf.util;/**
 * Created by Ives on 16/8/30.
 */

import com.chenjiarun.psf.exception.BusinessException;
import com.chenjiarun.psf.model.StatusPair;

/**
 * psf
 * 功能： http请求的工具类,提供检查参数控制等通用方法
 * -------------------------------------------------------------------------------------------------
 * 创建者：陈佳润
 * -------------------------------------------------------------------------------------------------
 * 创建日期：2016-08-30  15:17
 * -------------------------------------------------------------------------------------------------
 * 更新历史(日期/更新人/更新内容)
 */
public class RequestUtils {

    /**
     * 检查参数是否为空
     *
     * @param field      参数
     * @param statusPair 错误提示StatusPair
     * @throws BusinessException
     */
    public static void checkNullField(Object field, StatusPair statusPair) throws BusinessException {

        if (field == null) {

            throw new BusinessException(statusPair);

        }
    }

}
