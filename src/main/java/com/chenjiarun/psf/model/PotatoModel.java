package com.chenjiarun.psf.model;/**
 * Created by Ives on 16/8/29.
 */

/**
 * PotatoServiceFramework
 * 功能： 实体类的基类,与mybatis部分的PotatoDao.xml协同,在框架层面实现了分页
 * -------------------------------------------------------------------------------------------------
 * 创建者：陈佳润
 * -------------------------------------------------------------------------------------------------
 * 创建日期：2016-08-29  21:57
 * -------------------------------------------------------------------------------------------------
 * 更新历史(日期/更新人/更新内容)
 */
public class PotatoModel {

    /**
     * 排序字段 order by #{sort} #{order}
     */
    private String sort;

    /**
     * 升序还是降序,有两种情况 ASC、DESC,默认为降序
     */
    private String order;

    /**
     * 每次获取limit条数据,默认为10
     */
    private Integer limit = 10;

    /**
     * 数据起始下标
     */
    private Long offset = 0L;


}
