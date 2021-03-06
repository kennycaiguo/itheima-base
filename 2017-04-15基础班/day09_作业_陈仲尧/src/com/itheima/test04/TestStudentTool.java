package com.itheima.test04;

public class TestStudentTool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] students = new Student[5];

		// for (int i = 0; i < students.length; i++) {
		// students[i] = new Student();
		// }

		students[0] = new Student("Alan Turing", "43", 90);
		students[1] = new Student("Ken Thompson", "74", 75);
		students[2] = new Student("Linus Torvalds", "48", 62);
		students[3] = new Student("Steve Jobs", "56", 48);
		students[4] = new Student("Bill Gates", "62", 59);

		StudensTool studensTool = new StudensTool();

		studensTool.listStudents(students);

		System.out.println("最高分为：" + studensTool.getMaxScore(students));

		System.out.println("获得最高分的是：" + studensTool.getMaxStudent(students).getName());

		System.out.println("平均分为：" + studensTool.getAverageScore(students));

		System.out.println("不及格人数：" + studensTool.getCount(students));

	}

}
