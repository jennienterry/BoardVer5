package com.koreait.board5.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;
import com.koreait.board5.cmt.CmtDAO;
import com.koreait.board5.cmt.CmtVO;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int iboard = MyUtils.getParamInt("iboard", request);
		BoardVO vo = new BoardVO();
		vo.setIboard(iboard);
		vo = BoardDAO.selBoard(vo);
		List<CmtVO> cmtlist = CmtDAO.selCmtList(vo);
		request.setAttribute("cmtList", cmtlist);
		request.setAttribute("vo", vo);
		MyUtils.openJSP("board/detail", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}