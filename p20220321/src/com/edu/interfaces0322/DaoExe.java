package com.edu.interfaces0322;

public class DaoExe {
	public static void main(String[] args) {
		Dao/*인터페이스*/ dao/*구현객체*/ = new MySqlDao(); //new OracleDao();
		
		dao.select();
		
		dao.insert();
		
		dao.update();
		
		dao.delete();
		
	}
}
