package com.itheima.test2;

/**
 * 高档奥迪类
 * 
 * @author Ulric
 *
 */
public class TopGradeAudi extends CommonAudi implements TopGradeFunc {

	public TopGradeAudi() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void autoPark() {
		// TODO Auto-generated method stub
		System.out.println("高端奥迪具有自动停车功能");
	}

	@Override
	public void autoDrive() {
		// TODO Auto-generated method stub
		System.out.println("高端奥迪具有自动驾驶功能");
	}

}
