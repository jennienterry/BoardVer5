package com.jimin.board7.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/idChk")
public class IdChkAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String uid = request.getParameter("uid");
			System.out.println("uid : " + uid);
			int result = UserDAO.selIdChk(uid);
			
			response.getWriter()
			.append("{\"result\": ")
			//"<html><body><h1>안녕하세요</h1></body></html>" 원래 이렇게 들어감
			.append(String.valueOf(result))
			.append("}"); // 내 주소값을 계속 return
	}
//			가독성을 위해서 append사용, +를 많이 사용하지 않도록
//			StringBuilder는 append와 같은 용도지만 for문 안에서는 x
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
