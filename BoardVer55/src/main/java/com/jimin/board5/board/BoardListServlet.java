package com.jimin.board5.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimin.board5.MyUtils;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!(MyUtils.isLogin(request))) {
			response.sendRedirect("/user/login");
			return;
		}
		
		List<BoardVO> list = BoardDAO.SelboardList();
		System.out.println(list.size());
		request.setAttribute("list", list);
		
		MyUtils.openJSP("board/list", request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String iuser = request.getParameter("iuser");
		int iboard = MyUtils.getParamInt("iboard", request);
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
	}

}
