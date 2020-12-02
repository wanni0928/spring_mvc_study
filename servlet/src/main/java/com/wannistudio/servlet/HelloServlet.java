package com.wannistudio.servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // init 이후 로직은 init을 생략하고 doGet 선언
        ApplicationContext context = (ApplicationContext) getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        HelloService bean = context.getBean(HelloService.class);
    }

    @Override
    public void destroy() {
        super.destroy(); // 애플리케이션 종료 하기 직전 실행

    }

    @Override
    public void init() throws ServletException { // 애플리케이션 run 이후 한번 사용.
        System.out.println("init");
    }
}
