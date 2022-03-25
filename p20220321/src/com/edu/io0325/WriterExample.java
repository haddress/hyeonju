package com.edu.io0325;

import java.io.FileWriter;
import java.io.IOException;

public class WriterExample {
	public static void main(String[] args) {
		// 출력스트림을 문자기반으로 -> second.txt 
		try {
			FileWriter fw = new FileWriter("second.txt");
			fw.write("Hello\n");
			fw.write("world\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog");
	}

}
