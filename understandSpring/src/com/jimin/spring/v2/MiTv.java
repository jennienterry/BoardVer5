package com.jimin.spring.v2;

import com.jimin.java.Speaker;

public class MiTv {
	private Speaker speaker;
	
	
	public MiTv() {
		System.out.println("MiTv 기본 생성자");
	}
	
	public MiTv(Speaker speaker) {
		System.out.println("MiTv speaker 생성자");
		this.speaker = speaker;
	}
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public void volumeUp() {
		speaker.volumeUp();
	}
	//에러 터지는 이유 : speaker가 null
}
