package com.chenjiarun.psf.model;/**
 * Created by Ives on 16/8/29.
 */

/**
 * PotatoServiceFramework
 * 功能： 网络请求的结果对象
 * -------------------------------------------------------------------------------------------------
 * 创建者：陈佳润
 * -------------------------------------------------------------------------------------------------
 * 创建日期：2016-08-29  22:22
 * -------------------------------------------------------------------------------------------------
 * 更新历史(日期/更新人/更新内容)
 */
public class ResultModel {

    /**
     * 消息
     */
    private String msg;

    /**
     * 状态吗
     */
    private Integer code;

    /**
     * 数据
     */
    private Object data;

    /**
     * 状态,true表示请求成功,false表示请求失败,默认为false
     */
    private Boolean status = false;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
