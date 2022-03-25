package com.edu.io0325;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileInOutExample {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("c:/temp/puppy.jpg");
			FileOutputStream fos = new FileOutputStream("c:/temp/copy2.jpg");
			
			int readByte = -1;
			byte[] readBytes = new byte[100];
			while((readByte = fis.read(readBytes)) != -1) {
				fos.write(readBytes, 0, readByte); // 100바이트를 못 채운 경우 채워지는 만큼만
			}
			fos.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog");
	}

}
