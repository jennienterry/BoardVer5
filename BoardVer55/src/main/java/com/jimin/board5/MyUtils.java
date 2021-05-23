package com.jimin.board5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jimin.board5.user.UserVO;

public class MyUtils {
		
	public static void openJSP(String fileNm, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jsp = "/WEB-INF/view/" + fileNm + ".jsp";
		request.getRequestDispatcher(jsp).forward(request,response);
		
	}
	
	public static int parseStringInt(String str) {
		try {
			return Integer.parseInt(str);
		}catch(Exception e) {
			e.printStackTrace();
		}return 0;
	}
	
	public static int getParamInt(String str, HttpServletRequest request) {
		return parseStringInt(request.getParameter(str));
	}
	
	public static UserVO getloginUser(HttpServletRequest request) {
		if(request==null) {return null;}
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");
		return loginUser;
	}
	
	public static int getloginUserPK(HttpServletRequest request) {
		return getloginUser(request).getIuser();
	}
	
	public static boolean isLogin(HttpServletRequest request) {
		if(getloginUser(request) == null) {
			return false;
		}else return true;
	}
}
