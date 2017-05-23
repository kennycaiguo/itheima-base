package com.itheima;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		welcome();
		Scanner sc = new Scanner(System.in);
		while (true) {
			String input = sc.nextLine();
			input = input.toUpperCase();
			if (input.equals("A")) {// 输入 A 则调用登录方法
				signIn();
				break;// 登录成功后切换到菜单
			} else if (input.equals("B")) {// 输入 B 则调用 注册 方法
				signUp();
			} else if (input.equals("Q")) {// 输入 Q 则退出
				System.out.println("谢谢使用！祝您生活愉快！");
				System.exit(1);
			} else {// 输入其他字符则提示
				System.out.println("非法输入！请重新选择： 用户登录(A) 注册用户(B) 退出系统(Q)");
			}
		}

		// 登录成功后执行到此处
		printMenu();

	}

	/********** 打印欢迎界面 **********/
	public static void welcome() throws IOException {
		System.out.println("*****************************************");
		System.out.println("*\t\t\t\t\t*");
		System.out.println("*\t\t\t\t\t*");
		System.out.println("*\t\t\t\t\t*");
		System.out.println("*\t\t\t\t\t*");
		System.out.println("*\t    欢迎使用图书管理系统\t\t*");
		System.out.println("*\t\t\t\t\t*");
		System.out.println("*\t\t\t\t\t*");
		System.out.println("*\t\t\t\t\t*");
		System.out.println("*\t\t\t\t\t*");
		System.out.println("*\t\t\t\t\t*");
		System.out.println("*****************************************");
		System.out.println("请选择功能：用户登录(A) 注册用户(B) 退出系统(Q)");
	}

	/********** 输出菜单 **********/
	public static void printMenu() {
		System.out.println("请选择功能：");
		System.out.println("查看图书(A) 添加图书(B) 修改图书(C) 删除图书(D)");
		System.out.println("修改用户名(E) 修改密码(F) 查看所有用户(G) 注销(Q)");
	}

	/********** 注册用户 **********/
	public static void signUp() throws IOException {
		// 正则表达式
		String usrNameReg = "[a-zA-Z]+[a-zA-Z_0-9]*";
		String pwdReg = "[a-zA-Z0-9]{6,12}";

		BufferedReader bReader = new BufferedReader(new FileReader("user.txt"));
		Scanner sc = new Scanner(System.in);

		// 输入用户名并判断
		System.out.println("请输入用户名：");
		String usrNameInput;
		boolean isUsrNameOK;// 用户名是否通过
		while (true) {
			isUsrNameOK = true;
			usrNameInput = sc.nextLine();
			String readLn;
			// 循环读取文件中的数据，检测用户名是否已经存在
			while ((readLn = bReader.readLine()) != null) {
				if (readLn.split("=")[0].equals(usrNameInput)) {// 如果输入的用户名已存在
					System.out.println("用户名已存在，请重新输入：");
					isUsrNameOK = false;
					break;
				}

			}

			// 如果输入的用户名非法
			if (!usrNameInput.matches(usrNameReg)) {
				System.out.println("用户名只能包含字母、下划线和数字组成，但只能以字母开头，请重新输入：");
				isUsrNameOK = false;
			}

			// 用户名通过则退出循环
			if (isUsrNameOK) {
				break;
			}
		}
		bReader.close();

		// 输入并判断密码是否合法
		String pwdInput;
		System.out.println("请输入密码：");
		while (true) {
			pwdInput = sc.nextLine();
			if (pwdInput.matches(pwdReg)) {// 如果合法就跳出循环
				break;
			} else {// 否则就继续输入
				System.out.println("密码只能包含字母和数字，长度在6到12之间，请重新输入：");
			}
		}
		sc.close();

		// 用户名和密码都通过
		BufferedWriter bWriter = new BufferedWriter(new FileWriter("user.txt", true));
		bWriter.write(usrNameInput + "=" + pwdInput);
		bWriter.newLine();
		bWriter.close();

		System.out.println("注册成功！");
		System.out.println("请选择功能：用户登录(A) 注册用户(B) 退出系统(Q)");

	}

	/********** 用户登录 **********/
	public static void signIn() throws IOException {
		BufferedReader bReader = new BufferedReader(new FileReader("user.txt"));
		Scanner sc = new Scanner(System.in);

		System.out.println("请输入用户名：");
		// 检查用户名是否存在
		boolean isUsrNameExist = false;
		String usrNameInput;
		while (true) {
			usrNameInput = sc.nextLine();
			String readLn;
			while ((readLn = bReader.readLine()) != null) {
				if (readLn.split("=")[0].equals(usrNameInput)) {
					isUsrNameExist = true;
					break;
				}
			}
			// 如果用户名存在就跳出循环
			if (isUsrNameExist) {
				break;
			} else {// 用户名不存在则提示
				System.out.println("用户名不存在，请检查后重新输入：");
			}
		}
		bReader.close();

		/*
		 * 为什么两次读取文件之间需要先关闭流，然后再重新指向该文件读取？
		 */

		// 检查密码是否正确
		bReader = new BufferedReader(new FileReader("user.txt"));
		System.out.println("请输入密码：");
		while (true) {
			boolean isPwdCorrect = false;
			String pwdInput = sc.nextLine();
			String readLn;
			while ((readLn = bReader.readLine()) != null) {
				if (readLn.split("=")[1].equals(pwdInput)) {
					isPwdCorrect = true;
					break;
				}
			}
			// 如果密码输入正确就跳出循环
			if (isPwdCorrect) {
				break;
			} else {// 密码错误则提示
				System.out.println("密码错误！请重新输入：");
			}
		}
		bReader.close();
		sc.close();

		// 登录成功
		System.out.println("欢迎 " + usrNameInput + " ！");
	}

	/********** 查看图书 **********/
	public static void checkBooks() throws IOException {
		BufferedReader bReader = new BufferedReader(new FileReader("books.txt"));
		System.out.println("|书名|\t\t|作者|\t|出版社|\t\t|价格|\t|出版日期|");
		String readLn;
		while ((readLn = bReader.readLine()) != null) {
			String[] datas = readLn.split("--");
			for (int i = 0; i < datas.length; i++) {
				System.out.print(datas[i] + "\t");
				// if (i == 0 || i == 2) {// 如果信息是书名或出版社，则输出后再输出一次\t
				// System.out.print("\t");
				// }
			}
			System.out.println();
		}
		bReader.close();

	}

	/********** 添加图书 **********/
	// 1.如何进行查重
	public static void addBook() throws IOException {
		Scanner sc = new Scanner(System.in);

		System.out.println("请输入书号：");
		String bookNumReg = "ISBN[0-9]{6,9}-[0-9]";// 模拟书号规则
		String bookNumber = sc.nextLine();

		System.out.println("请输入书名：");
		String bookName = sc.nextLine();
		System.out.println("请输入作者：");
		String author = sc.nextLine();
		System.out.println("请输入出版社：");
		String press = sc.nextLine();
		System.out.println("请输入价格：");
		double price = 0.0;
		try {
			price = sc.nextDouble();
		} catch (InputMismatchException e) {

		}
		System.out.println("请输入出版日期：");
		String publicationDate = sc.nextLine();

		System.out.println("新书信息如下：书名：" + bookName + " 作者：" + author + " 出版社：" + press + " 价格：" + price + " 书号："
				+ bookNumber + " 出版日期：" + publicationDate);
		System.out.println("是否保存该书：(Y)是 (N)否");
		if (sc.nextLine().toUpperCase().equals("Y")) {

		} else {

		}

		BufferedWriter bWriter = new BufferedWriter(new FileWriter("books.txt"));
	}

	/********** 修改图书 **********/
	public static void alterBook() {

	}

	/********** 删除图书 **********/
	public static void deleteBook() {

	}
}