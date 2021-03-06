package com.chenjiarun.psf.aspect;/**
 * Created by Ives on 16/8/29.
 */

import com.chenjiarun.psf.annotation.PotatoResponse;
import com.chenjiarun.psf.constant.HttpConstant;
import com.chenjiarun.psf.constant.StatusConstant;
import com.chenjiarun.psf.controller.PotatoController;
import com.chenjiarun.psf.exception.BusinessException;
import com.chenjiarun.psf.exception.SystemException;
import com.chenjiarun.psf.model.ResultModel;
import com.chenjiarun.psf.util.JsonUtils;
import com.chenjiarun.psf.util.ResultUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * PotatoServiceFramework
 * 功能：进行PotatoResponse注解的处理,使用注解@Component是为了让Spring能扫描到它
 * -------------------------------------------------------------------------------------------------
 * 创建者：陈佳润
 * -------------------------------------------------------------------------------------------------
 * 创建日期：2016-08-29  21:53
 * -------------------------------------------------------------------------------------------------
 * 更新历史(日期/更新人/更新内容)
 */
@Component
@Aspect
public class PotatoAspect {


    @Around("@annotation(potatoResponse)")
    public void around(ProceedingJoinPoint proceedingJoinPoint, PotatoResponse potatoResponse) {

        PotatoController potatoController = (PotatoController) proceedingJoinPoint.getTarget();

        ResultModel resultModel = null;

        try {

            proceedingJoinPoint.proceed();

            resultModel = potatoController.getResultModel();

        } catch (BusinessException be) {

            resultModel = potatoController.getResultModel();
            ResultUtils.setStatusPair(resultModel, be.getStatusPair());
            ResultUtils.setStatus(resultModel, false);

        } catch (SystemException se) {

            resultModel = potatoController.getResultModel();
            ResultUtils.setStatusPair(resultModel, se.getStatusPair());
            ResultUtils.setStatus(resultModel, false);

        } catch (Throwable throwable) {

            resultModel = potatoController.getResultModel();
            ResultUtils.setStatusPair(resultModel, StatusConstant.ERROR_SYSTEM_UNKNOW);
            ResultUtils.setStatus(resultModel, false);

            throwable.printStackTrace();
        }


        String resultStr = null;

        try {

            resultStr = JsonUtils.toJsonString(resultModel);

        } catch (SystemException e) {
            e.printStackTrace();
        }


        HttpServletResponse response = beautifyResponse(potatoController.getHttpServletResponse());

        PrintWriter printWriter = null;

        try {

            printWriter = response.getWriter();

            if (resultStr != null) {

                printWriter.write(resultStr);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 设置Response的相关参数
     *
     * @param response
     * @return
     */
    private HttpServletResponse beautifyResponse(HttpServletResponse response) {

        response.setCharacterEncoding(HttpConstant.RESPONSE_CHARACTER_ENCODING);
        response.setContentType(HttpConstant.RESPONSE_CONTENT_TYPE);
        response.setHeader(HttpConstant.RESPONSE_ALLOW_ORIGIN_KEY, HttpConstant.RESPONSE_ALLOW_ORIGIN_VALUE);

        return response;
    }


}
