package com.skku_tinder.demo.security;

import com.skku_tinder.demo.exception.UserAuthException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class jwtExceptionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        try{
            filterChain.doFilter(request, response);
        }catch (UserAuthException e)
        {
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            System.out.println("필터");
            JSONObject responseJson = new JSONObject();
            try {
                responseJson.put("message", e.getMessage());
                responseJson.put("code", 500);
                response.getWriter().print(responseJson);
            } catch (JSONException exception) {
                exception.printStackTrace();
            }

        }
    }
}
