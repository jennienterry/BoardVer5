package com.jimin.java;

public class TvTest {
	// 메인메소드 : 프로젝트의 시작점이라서 중요하다. (특별한 점) 없으면 프로그램 시작 못함
	public static void main(String[] args) {
		Tv lgtv = new LgTv(new AppleSpeaker(40));
		Tv samtv = new SamsungTv(new SonySpeaker(30));

		// toString없이는 주소값이 출력된다.
		System.out.println(lgtv); // LgTv, 100인치, 40채널, 50볼륨
//		System.out.println(lgtv.toString()); = lgtv클래스에 toString을 override한다.
		System.out.println(samtv); // SamsungTv, 90인치, 30채널, 40볼륨

//		모든 객체에 다 있다 = Object의 메소드다. (무조건 상속받기 떄문)

//		확인용
//		for (int i = 0; i < 43; i++) {
//			lgtv.channelUp();
//		}
//		
//		for(int i = 0; i<55; i++) {
//			lgtv.volumeUp();
//		}
	}

}
