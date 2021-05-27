package com.jimin.board7.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimin.board7.MyUtils;

@WebServlet("/board/mod")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int iboard = MyUtils.getParamInt("iboard", request);
		BoardDTO vo = new BoardDTO();
		vo.setIboard(iboard);

		request.setAttribute("vo", BoardDAO.selBoard(vo));
		MyUtils.openJSP("mod", "board/boardMod", request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int iuser = MyUtils.getLoginUserPk(request);
		int iboard = MyUtils.getParamInt("iboard", request);

		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");

		BoardEntity vo = new BoardEntity();
		vo.setIuser(iuser);
		vo.setIboard(iboard);
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		
		BoardDAO.modBoard(vo);
		response.sendRedirect("detail?iboard=" + iboard);
	}

}
