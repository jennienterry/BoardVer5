package com.jimin.board7.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimin.board7.MyUtils;

@WebServlet("/board/write")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("write", "/board/boardWrite", request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		int iuser =  MyUtils.getLoginUserPk(request);
		
		BoardEntity vo = new BoardEntity();
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		vo.setIuser(iuser);
//		BoardDAO.글쓰기(vo);
		request.setAttribute("vo", vo);
	}

}
