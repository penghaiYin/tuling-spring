package com.tuling;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 客户端发送一个请求到web容器，调用我们相应的Servlet，判断请求是get还是post，然后doGet或者doPost分发最终响应
 * 客户端接收到重定向的请求，会再次请求服务器的index.jsp，jsp进行渲染成html，再次响应客户端
 */
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("action");
            if("login".equals(method)){
                login(req,resp);
            }
        }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
        //数据库校验
        resp.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }


}
