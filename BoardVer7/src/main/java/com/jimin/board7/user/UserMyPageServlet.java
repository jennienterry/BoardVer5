package com.jimin.board7.user;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimin.board7.MyUtils;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/user/mypage")
public class UserMyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("마이페이지", "user/userMypage", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadPath = request.getServletContext().getRealPath("/res/img");
		int maxFileSize = 10_485_760; // 10*1024*1024 (10mb)
		System.out.println("uploadPath : " + uploadPath); //경로확인용								//중복된이름 있으면 1추가해서 저장해주는 객체
		MultipartRequest multi = new MultipartRequest(request, uploadPath + "/temp", maxFileSize, "UTF-8", new DefaultFileRenamePolicy());
		
		int loginUserPk = MyUtils.getLoginUserPk(request);
		
		String targetFolder = uploadPath + "/user/" + loginUserPk;
		
		File folder = new File(targetFolder);
		folder.mkdirs(); //있는지 없는지 체크하고 없으면 폴더 만들어줌
		
		String fileNm = multi.getFilesystemName("profileImg"); //userMypage.jsp에서 준 name값
		System.out.println("fileNm" + fileNm);
		
		int lastDotIdx = fileNm.lastIndexOf("."); 
		String ext = fileNm.substring(lastDotIdx); //확장자 구함
		//Strint ext2 = fileNm.substring(fileNm.lastIndexOf(".") + 1);
		
		String newFileNm = UUID.randomUUID().toString() + ext;
		
		File imgFile = new File(uploadPath + "/temp" + "/" + fileNm);
		imgFile.renameTo(new File(targetFolder + "/" + newFileNm));
		String path = newFileNm;
		
		MyUtils.getLoginUser(request).setProfileImg(path);
		UserEntity img = new UserEntity();
		img.setIuser(loginUserPk);
		img.setProfileImg(path);
		UserDAO.updProfileImg(img);
		
		response.sendRedirect("mypage");
	}

}

/* 어플리케이션 받아오는 방법
 * ServletContext context = request.getServletContext();
 * String path = context.getRealPath("/");
*/
