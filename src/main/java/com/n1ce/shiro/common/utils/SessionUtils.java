package com.n1ce.shiro.common.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import java.util.UUID;

import static com.n1ce.shiro.common.constants.CommonConstants.SESSION_UUID;

/**
 * @author N1CE
 * @date 2017/11/28
 */
public class SessionUtils {

    private static SessionUtils utils=new SessionUtils();

    public static SessionUtils getSessionUtils(){
        return utils;
    }
    public String generatorUuid(){
        String str= UUID.randomUUID().toString();
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute(SESSION_UUID, str);
        return str;
    }

}
