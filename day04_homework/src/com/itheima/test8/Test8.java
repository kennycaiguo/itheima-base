package com.itheima.test8;

public class Test8 {

	public static void main(String[] args) {
		new Player() {
			
			@Override
			public void playPingpong() {
				System.out.println("playPingpong()");
				
			}
			
			@Override
			public void playBasketball() {
				System.out.println("playBasketball()");
			}
//		}.playBasketball();
		}.playPingpong();
	}

}
