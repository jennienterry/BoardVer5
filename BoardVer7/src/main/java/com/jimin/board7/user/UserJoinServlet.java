package com.jimin.board7.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.jimin.board7.MyUtils;


@WebServlet("/user/join")
public class UserJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("join", "user/userJoin", request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		String hashUpw = BCrypt.hashpw(upw,BCrypt.gensalt()); 
		int gender = MyUtils.getParamInt("gender", request);
		String unm = request.getParameter("unm");
		
		UserEntity join = new UserEntity();
		join.setUid(uid);
		join.setUpw(hashUpw);
		join.setGender(gender);
		join.setUnm(unm);
		
		UserDAO.joinUser(join);
		
		response.sendRedirect("login");
	}

}
