package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/step04/exam02")
public class Exam02 extends GenericServlet {
    private static final long serialVersionUID = 1L;
    
    // 테스트 방법
    // http://localhost:8888/bitcamp-web01/step04/exam02_test.html
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        //클라이언트가 보낸 값을 꺼낼 떄는 GET, POST 구분없이 동일한 방법으로 값을 꺼낸다.
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        String method = httpRequest.getMethod();
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.printf("요청 방식=%s\n", method);
        out.printf("name=%s\n", name);
        out.printf("age=%d\n", age);
    }
}
