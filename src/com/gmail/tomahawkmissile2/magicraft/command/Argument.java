package com.gmail.tomahawkmissile2.magicraft.command;

public class Argument {
	
	String name;
	
	public Argument() {}
	public Argument(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public boolean isValidArgument(String arg) {
		if(name==null||name.equals("")) return true;
		return this.getName().equalsIgnoreCase(arg);
	}
}
