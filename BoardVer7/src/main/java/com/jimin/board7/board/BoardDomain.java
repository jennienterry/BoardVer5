package com.jimin.board7.board;

public class BoardDomain extends BoardEntity{
	private String writerNm;
	private String profileImg;
	
	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String getWriterNm() {
		return writerNm;
	}

	public void setWriterNm(String writerNm) {
		this.writerNm = writerNm;
	}
	
}

//Domain이 더 큼, Domain이 가지고 있는 매개변수를 Entity도 사용할 수 있음