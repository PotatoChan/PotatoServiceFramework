package com.chenjiarun.psf.util;/**
 * Created by Ives on 16/8/29.
 */

import com.chenjiarun.psf.constant.HttpConstant;
import com.chenjiarun.psf.constant.StatusConstant;
import com.chenjiarun.psf.controller.PotatoController;
import com.chenjiarun.psf.model.ResultModel;
import com.chenjiarun.psf.model.StatusPair;

import java.util.Map;

/**
 * PotatoServiceFramework
 * 功能： ResultModel的工具类,方便Controller进行响应结果的设置
 * -------------------------------------------------------------------------------------------------
 * 创建者：陈佳润
 * -------------------------------------------------------------------------------------------------
 * 创建日期：2016-08-29  22:21
 * -------------------------------------------------------------------------------------------------
 * 更新历史(日期/更新人/更新内容)
 */
public class ResultUtils {


    /**
     * 设置状态值
     *
     * @param resultModel 请求结果对象
     * @param status      状态值
     */
    public static void setStatus(ResultModel resultModel, Boolean status) {

        if (isNotEmpty(resultModel)) {
            resultModel.setStatus(status);
        }

    }

    /**
     * 设置提示信息
     *
     * @param resultModel 请求结果对象
     * @param msg         提示信息
     */
    public static void setMsg(ResultModel resultModel, String msg) {

        if (isNotEmpty(resultModel)) {
            resultModel.setMsg(msg);
        }

    }

    /**
     * 设置状态码
     *
     * @param resultModel 请求结果对象
     * @param code        状态码
     */
    public static void setCode(ResultModel resultModel, Integer code) {
        if (isNotEmpty(resultModel)) {
            resultModel.setCode(code);
        }
    }

    /**
     * 通过StatusPair对象设置状态值与提示信息
     *
     * @param resultModel 请求结果对象
     * @param statusPair  状态码-信息 对象
     */
    public static void setStatusPair(ResultModel resultModel, StatusPair statusPair) {

        if (isNotEmpty(resultModel)) {

            resultModel.setCode(statusPair.getCode());
            resultModel.setMsg(statusPair.getMsg());
        }
    }

    /**
     * 设置响应数据
     *
     * @param resultModel 请求结果对象
     * @param data        响应数据
     */
    public static void setData(ResultModel resultModel, Object data) {
        if (isNotEmpty(resultModel)) {
            resultModel.setData(data);
        }
    }


    /**
     * 往data中添加子项
     *
     * @param data        响应数据
     * @param subDataName 响应子数据名称
     * @param subData     响应子数据
     * @return
     */
    public static Map<String, Object> addSubData(Map<String, Object> data, String subDataName, Object subData) {


        if (isNotEmpty(data) && isNotEmpty(subDataName) && isNotEmpty(subData)) {

            data.put(subDataName, subData);
        }

        return data;
    }


    /**
     * 往data中添加数组类型数据
     *
     * @param data        响应数据
     * @param subDataName 响应子数据名称
     * @param subData     响应子数据(数组)
     * @param total       数组长度
     * @return
     */
    public static Map<String, Object> addSubData(Map<String, Object> data, String subDataName, Object subData, Long total) {

        addSubData(data, subDataName, subData);
        addSubData(data, HttpConstant.TOTAL, total);

        return data;
    }


    /**
     * 设置结果集,默认成功, 状态码与提示信息参照 StatusConstant.SUCCESS
     *
     * @param resultModel 请求结果对象
     * @param data        响应数据
     */
    public static void setResult(ResultModel resultModel, Object data) {

        if (isNotEmpty(resultModel) && isNotEmpty(data)) {

            setData(resultModel, data);

            setStatusPair(resultModel, StatusConstant.SUCCESS);

            setStatus(resultModel, true);

        }
    }

    /**
     * 设置结果集,默认成功, 状态码与提示信息参照 StatusConstant.SUCCESS,适用于无信息返回的操作
     *
     * @param resultModel 请求结果对象
     */
    public static void setResult(ResultModel resultModel) {

        if (isNotEmpty(resultModel)) {
            setStatusPair(resultModel, StatusConstant.SUCCESS);
            setStatus(resultModel, true);
        }
    }


    /**
     * 设置结果集,默认成功, 状态码与提示信息参照 StatusConstant.SUCCESS
     *
     * @param potatoController Controller的基类,可从中获取RequestModel
     * @param data             响应数据
     */
    public static void setResult(PotatoController potatoController, Object data) {

        ResultModel resultModel = potatoController.getResultModel();

        if (isNotEmpty(resultModel) && isNotEmpty(data)) {

            setData(resultModel, data);

            setStatusPair(resultModel, StatusConstant.SUCCESS);

            setStatus(resultModel, true);

        }
    }

    /**
     * 设置结果集,默认成功, 状态码与提示信息参照 StatusConstant.SUCCESS
     *
     * @param potatoController Controller的基类,可从中获取RequestModel
     */
    public static void setResult(PotatoController potatoController) {

        ResultModel resultModel = potatoController.getResultModel();

        if (isNotEmpty(resultModel)) {

            setStatusPair(resultModel, StatusConstant.SUCCESS);

            setStatus(resultModel, true);

        }
    }


    /**
     * 判断ResultModels是否为空
     *
     * @param resultModel 请求结果对象
     * @return 是否为空
     */
    public static boolean isEmpty(ResultModel resultModel) {
        if (resultModel == null) {
            return true;
        }
        return false;
    }

    /**
     * 判断ResultModel是否不为空
     *
     * @param resultModel 请求结果对象
     * @return 是否不为空
     */
    public static boolean isNotEmpty(ResultModel resultModel) {
        return !isEmpty(resultModel);
    }


    /**
     * 判断对象是否为空
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        return false;
    }

    /**
     * 判断对象是否非空
     *
     * @param obj
     * @return
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }


}
