package com.edu.collect0323;

import java.io.*;
import java.util.*;

public class StudentServiceFile implements StudentService {

	// 필드
	List<Student> list = new ArrayList<Student>(); // ArrayList라는 클래스가 갖고있는 생성자
	File file;

	// 생성자
	// 기본생성자의 파일에 저장되어 있는 파일 정보를 읽어서 list값을 담아준다
	public StudentServiceFile() {
		try {
			FileReader fr = new FileReader("studentList.data");
			BufferedReader br = new BufferedReader(fr);
			String readBuffer = null;
			while ((readBuffer = br.readLine()) != null) {
				String[] contents = readBuffer.split(","); // 101,홍길동,80,90
//				contents[0] <= 101, contents[1] <= 홍길동, contents[2] <= 80, contents[3] <= 90;
				list.add(//
						new Student(Integer.parseInt(contents[0]), contents[1], Integer.parseInt(contents[2]),
						Integer.parseInt(contents[3])//
						));
			}
			br.close();
			fr.close();
		} catch (IOException e)/* 파일 읽지 못 할 경우 IOExeption */ {
			e.printStackTrace();
		}
	}

	@Override
	public void insertStudent(Student student) {
		list.add(student);
	}

	@Override
	public Student getStudent(int stuNum) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStuNum() == stuNum) {
				return list.get(i);
			}
		}
		return null;
	}

	@Override
	public List<Student> studentList() {
		return list;
	}

	@Override
	public void modifyStudent(Student student) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStuNum() == student.getStuNum()) {
				list.get(i).setEngScore(student.getEngScore());
				list.get(i).setKorScore(student.getKorScore());
			}

		}

	}

	@Override
	public void removeStudent(int stuNum) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStuNum() == stuNum) {
				list.remove(i);
			}
		}

	}

	@Override
	public List<Student> searchStudent(String stuName) {
		List<Student> searchList = new ArrayList<Student>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStuName().equals(stuName)) {
				searchList.add(list.get(i));
			}
		}
		return searchList;
	}

	@Override
	public void saveToFile() {
		// 작성했던 ArrayList<Student> list => 파일에 저장
		try {
			FileWriter fw = new FileWriter("studentList.data");
			BufferedWriter bw = new BufferedWriter(fw); // 보조스트림의 생성자의 매개값으로 기본스트림

			for (Student stud : list) {
				bw.write(stud.getStuNum() + ", " + stud.getStuName() + ", " + stud.getEngScore() + ", "
						+ stud.getKorScore() + "\n");
			}
			bw.close();
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
