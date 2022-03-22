package com.edu.interfaces0322;

public interface Dao extends RemoteControl, Run {

	public abstract void select();

	public void insert();

	public void update();

	public void delete();

}


// 인터페이스는 규칙을 정하기 위해 만드는 것, 다중 상속 가능
