package com.itheima.test04;

/**
 * 学生类
 * 
 * 属性：
 * 
 * 姓名name
 * 
 * 年龄age
 * 
 * 成绩score
 * 
 * 行为：
 * 
 * 吃饭eat()
 * 
 * stuty(String content)(content:表示学习的内容)
 * 
 * @author Ulric
 *
 */

public class Student {
	private String name;
	private String age;
	private int score;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String age, int score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void eat() {
		System.out.println(name + "吃了" + age + "年的饭");
	}

	public void study(String content) {
		System.out.println(name + "正在学习" + content + "，最终取得了" + score + "分的成绩");
	}

}
