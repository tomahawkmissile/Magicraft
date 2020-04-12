package com.gmail.tomahawkmissile2.magicraft.utils;

public class LevelManager {

	public static int getLevel(String input) {
		String[] ss = input.split(" ");
		for(String s : ss) {
			if(s.equals("I")) {
				return 1;
			} else if(s.equals("II")) {
				return 2;
			} else if(s.equals("III")) {
				return 3;
			} else if(s.equals("IV")) {
				return 4;
			} else if(s.equals("V")) {
				return 5;
			} else if(s.equals("VI")) {
				return 6;
			} else if(s.equals("VII")) {
				return 7;
			} else if(s.equals("VIII")) {
				return 8;
			} else if(s.equals("IX")) {
				return 9;
			} else if(s.equals("X")) {
				return 10;
			}
		}
		ss = input.split(".");
		return Integer.parseInt(ss[2]);
	}
}
