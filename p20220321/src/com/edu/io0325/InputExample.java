package com.edu.io0325;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputExample {
	public static void main(String[] args) {

		try {
			// 입력스트림을 생성 -> 키워드or파일 같은 것을 읽음(ex. first.dat에 내용 저장)
			InputStream is = new FileInputStream("first.dat");
			int readByte = 0;
			while ((readByte = is.read()) != -1) {
				System.out.println(readByte);
			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
