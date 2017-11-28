package com.n1ce.shiro.common.handler;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static com.n1ce.shiro.common.constants.CommonConstants.HTML_UUID;
import static com.n1ce.shiro.common.constants.CommonConstants.SESSION_UUID;

/**
 * @author N1CE
 * @date 2017/11/28
 */
public class BaseHandler {

    // 表单重复提交校验
    public static boolean isUuidValidate(HttpServletRequest request) {
        Session session = SecurityUtils.getSubject().getSession();
        if (null == session) {
            return false;
        }
        Object session_uuid = session.getAttribute(SESSION_UUID);
        if (null == session_uuid) {
            return false;
        }
        String html_uuid = request.getParameter(HTML_UUID);
        if (StringUtils.isEmpty(html_uuid)) {
            return false;
        }
        return session_uuid.toString().equals(html_uuid);
    }

    // 去掉session中的秘钥
    public void resetUuid(){
        Session session = SecurityUtils.getSubject().getSession();
        if (null == session) {
            return;
        }
        session.removeAttribute(SESSION_UUID);
    }


}
