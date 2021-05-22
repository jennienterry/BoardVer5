package com.jimin.board5.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.jimin.board5.MyUtils;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");
		if(loginUser != null) {
			response.sendRedirect("/board/list");
			return;
		}			
		MyUtils.openJSP("user/userlogin", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");

		UserVO vo = new UserVO();
		vo.setUid(uid);
		
		UserVO result = UserDAO.loginUser(vo);
		if(result == null) {
			request.setAttribute("errMsg", "아이디를 입력해주세요.");
		}else if(BCrypt.checkpw(upw, result.getUpw())){
			result.setUpw(null);
			HttpSession hs = request.getSession();
			hs.setAttribute("loginUser", result);
			response.sendRedirect("/board/list");
			return;
		}else {
			request.setAttribute("errMsg", "비밀번호를 입력해주세요.");
		}
		doGet(request, response);
		

}
}