package com.app.tera.config;

import org.json.JSONObject;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest req,
                       HttpServletResponse res,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {



        res.setContentType("application/json;charset=UTF-8");
        res.setStatus(HttpServletResponse.SC_FORBIDDEN);
        res.getWriter().write(new JSONObject()
                .put("timestamp", LocalDateTime.now())
                .put("message", "Access denied")
                .toString());
    }
}