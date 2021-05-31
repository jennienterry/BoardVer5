package com.jimin.spring;

import com.jimin.java.*;

public class SpringTvTest {

	public static void main(String[] args) {
		//외부 파일 읽음
		Speaker s1 = SpeakerFactory.choiceSpeaker(args[0]);
		Speaker s2 = SpeakerFactory.choiceSpeaker(args[1]);
//		실행할 때 화살표에 (debug) configuration ????
		
		Tv lgtv = new LgTv(s1);
		Tv samtv = new SamsungTv(s2);
		
// 		toString없이는 주소값이 출력된다.
		System.out.println(lgtv); // LgTv, 100인치, 40채널, 50볼륨
//		System.out.println(lgtv.toString()); = lgtv클래스에 toString을 override한다.
		System.out.println(samtv); // SamsungTv, 90인치, 30채널, 40볼륨
		
		for (int i = 0; i < 55; i++) {
			lgtv.channelUp();
			samtv.channelUp();
		}
	}
	

}
