package com.jimin.board7.user;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimin.board7.MyFileUtils;
import com.jimin.board7.MyUtils;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/user/mypage")
public class UserMyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MyUtils.openJSP("마이페이지", "user/userMypage", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String uploadPath = request.getRealPath("/res/img/temp");
//		ServletContext application = request.getServletContext(); 4개의 내장객체중 하나 (pageContext, request, session, application)
//		application.getRealPath(""); application은 공용
		String uploadPath = request.getServletContext().getRealPath("/res/img"); // 27,28 두 줄과 같음
		int maxFileSize = 10_485_760; // 10*1024*1024 (10mb)
		System.out.println("uploadPath : " + uploadPath); // 경로확인용 //중복된이름 있으면 1추가해서 저장해주는 객체

		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath + "/temp", maxFileSize, "UTF-8",
					new DefaultFileRenamePolicy());
			// 패킷에 있는 애들을 파일로 만들어주는 객체 파일정보가 있는 곳, 어디저장할래?, 폴더, 파일크기지정 (0주면 제한x),파일인코딩

			String fileNm = multi.getFilesystemName("profileImg"); // userMypage.jsp에서 준 name값
			System.out.println("fileNm" + fileNm);

			if (fileNm == null) {
				doGet(request, response);
				return;
			}

			int loginUserPk = MyUtils.getLoginUserPk(request);
			String targetFolder = uploadPath + "/user/" + loginUserPk;

			File folder = new File(targetFolder);
			MyFileUtils.delFolder(targetFolder); // 폴더 삭제
//			folder.delete(); // 폴더 삭제기능인데 안에 파일이 있으면 안지워짐 
			folder.mkdirs(); // 사진 등록 및 수정 / 있는지 없는지 체크하고 없으면 폴더 만들어줌

			int lastDotIdx = fileNm.lastIndexOf("."); // indexOf하면 왼쪽부터 찾음 /lastindexOf는 오른쪽부터 찾음 / index는 0부터
			String ext = fileNm.substring(lastDotIdx); // 확장자 구함
			// = Strint ext2 = fileNm.substring(fileNm.lastIndexOf("."));

			String newFileNm = UUID.randomUUID().toString() + ext; // UUID string으로 변환 ?????
			//랜덤의 문자열을 만들어주는데 중복될일이 없기 때문에 만들어주는 것
			
			File imgFile = new File(uploadPath + "/temp" + "/" + fileNm);
			imgFile.renameTo(new File(targetFolder + "/" + newFileNm));

			MyUtils.getLoginUser(request).setProfileImg(newFileNm);
			UserEntity param = new UserEntity();
			param.setIuser(loginUserPk);
			param.setProfileImg(newFileNm);
			UserDAO.updUser(param); // 메소드 2개인거 확인하기
		} catch (Exception e) {
			e.printStackTrace();
		}
		doGet(request, response); // = response.sendRedirect("mypage");
	}

}

/*
 * 어플리케이션 받아오는 방법 ServletContext context = request.getServletContext(); String
 * path = context.getRealPath("/");
 */
