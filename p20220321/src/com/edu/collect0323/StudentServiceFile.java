package com.edu.collect0323;

import java.io.*;
import java.util.*;

public class StudentServiceFile implements StudentService {

	List<Student> list = new ArrayList<Student>();
	File file;

	@Override
	public void insertStudent(Student student) {
		list.add(student);
	}

	@Override
	public Student getStudent(int sno) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStuNum() == sno) {
				return list.get(i);
			}
		}
		return null;
	}

	@Override
	public List<Student> studentList() {
		return null;
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
	public void removeStudent(int stuNo) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStuNum() == stuNo) {
				list.remove(i);
			}
		}

	}

	@Override
	public List<Student> searchStudent(String name) {
		List<Student> searchList = new ArrayList<Student>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStuName().equals(name)) {
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
			BufferedWriter bw = new BufferedWriter(fw);

			for (Student stud : list) {
				bw.write(stud.getStuNum() + ", " + stud.getStuName() + ", " + stud.getEngScore() + ", "
						+ stud.getKorScore());
			}
			bw.close();
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
