package com.chenjiarun.psf.util;/**
 * Created by Ives on 16/8/29.
 */

import com.chenjiarun.psf.constant.StatusConstant;
import com.chenjiarun.psf.exception.SystemException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

/**
 * PotatoServiceFramework
 * 功能：json
 * -------------------------------------------------------------------------------------------------
 * 创建者：陈佳润
 * -------------------------------------------------------------------------------------------------
 * 创建日期：2016-08-29  23:34
 * -------------------------------------------------------------------------------------------------
 * 更新历史(日期/更新人/更新内容)
 */
public class JsonUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    public static final String STANDARD_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    static {
        mapper.setDateFormat(new SimpleDateFormat(STANDARD_DATE_FORMAT));
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
    }

    public static String toJsonString(Object object) throws SystemException {
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();

            throw new SystemException(StatusConstant.ERROR_JSON_RESOLVE);
        }
    }

    public static <T> T toObject(String jsonString, Class<T> clazz) throws SystemException {
        try {
            return mapper.readValue(jsonString, clazz);
        } catch (Exception e) {
            e.printStackTrace();

            throw new SystemException(StatusConstant.ERROR_JSON_RESOLVE);
        }
    }

    public static <T> T toObject(JsonNode jsonNode, Class<T> clazz) throws SystemException {
        try {
            return mapper.readValue(jsonNode.traverse(), clazz);
        } catch (Exception e) {
            e.printStackTrace();

            throw new SystemException(StatusConstant.ERROR_JSON_RESOLVE);
        }
    }

    public static JsonNode toJsonNode(String jsonString) throws SystemException {
        try {
            return mapper.readTree(jsonString);

        } catch (Exception e) {
            e.printStackTrace();

            throw new SystemException(StatusConstant.ERROR_JSON_RESOLVE);
        }
    }

    public static void destroy() {
        mapper = null;
    }

}
