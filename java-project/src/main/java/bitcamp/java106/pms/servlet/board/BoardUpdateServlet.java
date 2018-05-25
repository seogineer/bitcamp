package bitcamp.java106.pms.servlet.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/board/update")
public class BoardUpdateServlet extends HttpServlet {
    BoardDao boardDao;

    @Override
    public void init() throws ServletException {
        ApplicationContext iocContainer = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        this.boardDao = iocContainer.getBean(BoardDao.class);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            Board board = new Board();
            board.setNo(Integer.parseInt(request.getParameter("no")));
            board.setTitle(request.getParameter("title"));
            board.setContent(request.getParameter("content"));
            
            int count = boardDao.update(board);
            if (count == 0) {
                throw new Exception("해당 게시물이 존재하지 않습니다.");
            }
            response.sendRedirect("list");
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("title", "게시물 변경 실패");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

}