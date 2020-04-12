package com.gmail.tomahawkmissile2.magicraft.utils;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

	public static List<Object> convertArrayToList(Object[] j) {
		List<Object> obj = new ArrayList<Object>();
		for(int i=0;i<j.length;i++) {
			obj.add(j[i]);
		}
		return obj;
	}
	public static Object[] convertListToArray(List<Object> j) {
		Object[] obj = new Object[j.size()];
		for(int i=0;i<j.size();i++) {
			obj[i]=j.indexOf(i);
		}
		return obj;
	}
}
