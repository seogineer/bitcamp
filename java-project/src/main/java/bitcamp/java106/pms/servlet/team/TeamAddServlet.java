package bitcamp.java106.pms.servlet.team;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/team/add")
public class TeamAddServlet extends HttpServlet {
    
    TeamDao teamDao;
    
    @Override
    public void init() throws ServletException {
        ApplicationContext iocContainer = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        teamDao = iocContainer.getBean(TeamDao.class);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            Team team = new Team();
            team.setName(request.getParameter("name"));
            team.setDescription(request.getParameter("description"));
            team.setMaxQty(Integer.parseInt(request.getParameter("maxQty")));
            team.setStartDate(Date.valueOf(request.getParameter("startDate")));
            team.setEndDate(Date.valueOf(request.getParameter("endDate")));
            
            teamDao.insert(team);
            response.sendRedirect("list");
            
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("title", "팀 등록 실패!");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
