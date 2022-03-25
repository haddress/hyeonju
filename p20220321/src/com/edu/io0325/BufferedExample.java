package com.edu.io0325;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedExample {
	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream("C:/temp/puppy.jpg");
				BufferedInputStream bis = new BufferedInputStream(fis); // 보조스트림 Buffered~ 를 통해 성능 향상
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:/temp/copy3.jpg"));) {
			// try() 구문안에다 선언해주면 close 따로 안해줘도 됨
			
			int readByte = -1;
			while ((readByte = bis.read()) != -1) {
				bos.write(readByte);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog");

	}
}
