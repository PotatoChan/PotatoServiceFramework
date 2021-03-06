package com.chenjiarun.psf.exception;/**
 * Created by Ives on 16/8/29.
 */

import com.chenjiarun.psf.model.StatusPair;

/**
 * PotatoServiceFramework
 * 功能：系统层面的Exception
 * -------------------------------------------------------------------------------------------------
 * 创建者：陈佳润
 * -------------------------------------------------------------------------------------------------
 * 创建日期：2016-08-29  21:58
 * -------------------------------------------------------------------------------------------------
 * 更新历史(日期/更新人/更新内容)
 */
public class SystemException extends Exception {

    private StatusPair statusPair;

    public SystemException(StatusPair statusPair) {
        this.statusPair = statusPair;
    }

    public StatusPair getStatusPair() {
        return statusPair;
    }

    public void setStatusPair(StatusPair statusPair) {
        this.statusPair = statusPair;
    }
}

