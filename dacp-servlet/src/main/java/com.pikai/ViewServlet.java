package com.pikai;

import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * 项目名称：dacp
 * 包名： com.pikai
 * 类名称：
 * 类描述：
 * 创建人：生活家.沃特
 * 创建时间：2016/10/2016/10/19 17:19
 */

@WebServlet(name = "ViewServlet", urlPatterns = {"/ViewServlet"})
public class ViewServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        请求转发与重定向
//##请求转发（RequestDispatcher）的过程：
// 客户首先发送一个请求到服务器端，服务器端发现匹配的servlet，并指定它去执行，当这个servlet执行完之后，
// 它要调用getRequestDispacther()方法，把请求转发给指定的test.jsp,整个流程都是在服务器端完成的，而且是在同一个请求里面完成的，
// 因此servlet和jsp共享的是同一个request，在servlet里面放的所有东西，在jsp中都能取出来，因此，
// jsp能把结果getAttribute()出来，getAttribute()出来后执行完把结果返回给客户端。整个过程是一个请求，一个响应。
        request.getRequestDispatcher("page.jsp").forward(request, response);

//###重定向（sendRedirect）的工作原理：
// 客户发送一个请求到服务器，服务器匹配servlet，这都和请求转发一样，servlet处理完之后调用了sendRedirect()这个方法，
// 这个方法是response的方法，所以，当这个servlet处理完之后，看到response.senRedirect()方法，立即向客户端返回这个响应，
// 响应行告诉客户端你必须要再发送一个请求，去访问test.jsp，紧接着客户端受到这个请求后，立刻发出一个新的请求，
// 去请求test.jsp,这里两个请求互不干扰，相互独立，在前面request里面setAttribute()的任何东西，在后面的request里面都获得不了。
// 可见，在sendRedirect()里面是两个请求，两个响应。
//        response.sendRedirect("page.jsp");
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }
}
