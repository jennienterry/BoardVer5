package com.jimin.board7.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimin.board7.MyUtils;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDTO param = new BoardDTO();

		//페이징 처리
		final int recordCnt = 5;
		int cPage = MyUtils.getParamInt("cPage", request);
		//쿼리스트링으로 cPage를 사용하지 않은경우 null값이 되는데 0이 반환되도록 해둠
		if(cPage == 0) {
			cPage = 1; //1page라도 보내주겠다.
		}
		int startIdx = (cPage-1)*recordCnt;
		
		param.setStartIdx(startIdx);
		param.setRecordCnt(recordCnt);
		
		
		//검색
		int searchType = MyUtils.getParamInt("searchType", request);
		String searchText = request.getParameter("searchText");
		
		if(searchType != 0 && searchText != null && !searchText.equals("")) {
			param.setSearchType(searchType);
			param.setSearchText(searchText);
			
		}
		request.setAttribute("pagingCnt", BoardDAO.selPagingCnt(param));
		request.setAttribute("list", BoardDAO.selBoardList(param));
		MyUtils.openJSP("리스트","board/boardList",request, response);
		
	}


}
