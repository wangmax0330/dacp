package com.pikai;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

@WebServlet(name = "PrintNumberToClientServlet", urlPatterns = {"/PrintNumberToClientServlet"})
public class PrintNumberToClientServlet extends HttpServlet {
    private static final long serialVersionUID = 4312868947607181532L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        outputOneByOutputStream(response);//使用OutputStream输出1到客户端浏览器
       // outputOneByPrintWriter(response);//使用PrintWriter 输出1 到客户端
    }

    /**
     * 使用OutputStream流输出数字1
     *
     * @param response
     * @throws IOException
     */
    public void outputOneByOutputStream(HttpServletResponse response) throws IOException {
        response.setHeader("content-type", "text/html;charset=UTF-8");
        OutputStream outputStream = response.getOutputStream();
        outputStream.write("使用OutputStream流输出数字1：".getBytes("UTF-8"));
        // write  是的是字节码,write(数字).它会转换成对应的码
        //在开发过程中，如果希望服务器输出什么浏览器就能看到什么，那么在服务器端都要以字符串的形式进行输出。
        //如果使用PrintWriter流输出数字，那么也要先将数字转换成字符串后再输出，如下：
        outputStream.write(123);
        outputStream.write("<br />".getBytes("UTF-8"));
        outputStream.write(48);
//            outputStream.write((1+"").getBytes());
    }

     /* 使用PrintWriter流输出数字1
     * @param request
     * @param response
     * @throws IOException
     */
    public void outputOneByPrintWriter(HttpServletResponse response) throws IOException{
        response.setHeader("content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();//获取PrintWriter输出流
        out.write("使用PrintWriter流输出数字1：");
        out.write(1+"");
    }

}
