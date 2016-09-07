package com.chenjiarun.psf.util;/**
 * Created by Ives on 16/8/30.
 */

import com.chenjiarun.psf.constant.StatusConstant;
import com.chenjiarun.psf.constant.SystemConstant;
import com.chenjiarun.psf.exception.SystemException;
import org.apache.commons.codec.digest.DigestUtils;


/**
 * psf
 * 功能：提供MD5加密功能
 * -------------------------------------------------------------------------------------------------
 * 创建者：陈佳润
 * -------------------------------------------------------------------------------------------------
 * 创建日期：2016-08-30  13:59
 * -------------------------------------------------------------------------------------------------
 * 更新历史(日期/更新人/更新内容)
 */
public class MD5Utils {

    /**
     * md5加密
     *
     * @param plaintext 明文
     * @return 密文
     * @throws SystemException 系统异常
     */
    public static String encode(String plaintext) throws SystemException {
        try {

            String result = DigestUtils.md5Hex(plaintext.getBytes(SystemConstant.ENCODING_UTF_8));

            return result.toUpperCase();

        } catch (Exception e) {

            throw new SystemException(StatusConstant.ERROR_MD5);
        }
    }

}
