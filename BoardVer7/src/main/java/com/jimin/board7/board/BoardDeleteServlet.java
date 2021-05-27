package com.jimin.board7.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimin.board7.MyUtils;

@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iuser = MyUtils.getLoginUserPk(request);
		int iboard = MyUtils.getParamInt("iboard", request);
		BoardEntity vo = new BoardEntity();
		vo.setIboard(iboard);
		vo.setIuser(iuser);
		BoardDAO.delBoard(vo);
		response.sendRedirect("list");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
