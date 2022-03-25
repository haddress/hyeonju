package com.edu.io0325;

import java.io.FileReader;
import java.io.IOException;

public class ReadExample {
	public static void main(String[] args) {
		try {
			// 문자기반 스트림 -> 한 문자씩 읽거나 씀
			FileReader fr = new FileReader("second.txt");
			int readChar = -1;
			while ((readChar = fr.read()) != -1) {
				System.out.print((char) readChar);
			}
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
