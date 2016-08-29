package com.chenjiarun.psf.controller;/**
 * Created by Ives on 16/8/29.
 */

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * PotatoServiceFramework
 * 功能： 所有Controller的基类
 * -------------------------------------------------------------------------------------------------
 * 创建者：陈佳润
 * -------------------------------------------------------------------------------------------------
 * 创建日期：2016-08-29  21:57
 * -------------------------------------------------------------------------------------------------
 * 更新历史(日期/更新人/更新内容)
 */
@Controller
public class PotatoController {

    /**
     * 客户端请求
     */
    private HttpServletResponse httpServletResponse;

    /**
     * 服务端响应
     */
    private HttpServletRequest httpServletRequest;

    /**
     * 在每个请求之前获取HttpServletRequest和HttpServletRequest
     *
     * @param httpServletRequest  客户端请求
     * @param httpServletResponse 服务端响应
     */
    public void handlerServlet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        this.httpServletRequest = httpServletRequest;
        this.httpServletResponse = httpServletResponse;
    }


}
