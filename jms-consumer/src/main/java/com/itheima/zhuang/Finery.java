package com.itheima.zhuang;

public abstract class Finery implements People {
	
	protected People people;
	
	public Finery(People people){
		this.people = people;
	}
	public abstract void wearClothing();
}
