package step05;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/step05/exam04")
public class Exam04 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 테스트 방법:
    // http://localhost:8888/bitcamp-web01/step05/exam04_test.html

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            Map<String, List<FileItem>> paramMap = upload.parseParameterMap(request);

            out.printf("name=%s\n", paramMap.get("name").get(0).getString("UTF-8"));
            out.printf("age=%s\n", paramMap.get("age").get(0).getString());
            
            FileItem photo = paramMap.get("photo").get(0);
            String filename = newFilename(photo.getName());
            out.printf("photo=%s\n", filename);
            
            ServletContext appEnvInfo = request.getServletContext();
            String savedPath = appEnvInfo.getRealPath("/");
            out.println(savedPath);
            photo.write(new File(savedPath + "/" + newFilename(photo.getName())));
            
        } catch (Exception e) {
            out.println("멀티파트 데이터 분석 중 오류 발생!");
        }

    }
    
    int count = 0;
    private String newFilename(String originFilename) {
        int lastIndex = originFilename.lastIndexOf(".");
        String extName = "";
        if(lastIndex >= 0) {
            extName = originFilename.substring(lastIndex);
        }
        
        return String.format("%s-%d%s", System.currentTimeMillis(), ++count, extName);
    }
}
