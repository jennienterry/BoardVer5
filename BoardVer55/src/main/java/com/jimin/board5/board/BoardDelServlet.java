package com.jimin.board5.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimin.board5.MyUtils;

@WebServlet("/board/del")
public class BoardDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!(MyUtils.isLogin(request))) {
			response.sendRedirect("/user/login");
			return;
		}
		
		int iboard = MyUtils.getParamInt("iboard", request);
		BoardDAO.delBoard(iboard);
		
		response.sendRedirect("/board/list");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
