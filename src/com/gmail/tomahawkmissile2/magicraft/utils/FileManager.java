package com.gmail.tomahawkmissile2.magicraft.utils;

import java.io.File;
import java.io.IOException;

public class FileManager {

	public static void createFolder(String path,String name) {
		File f = new File(path+"/"+name);
		if(!f.exists()) {
			f.mkdir();
		}
	}
	public static void createFolder(File file) {
		if(!file.exists()) {
			file.mkdir();
		}
	}
	public static void createFile(String path,String name) {
		File f = new File(path+"/"+name);
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void createFile(File file) {
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void deleteFile(File f) {
		new Thread() {
			public void run() {
				f.delete();
			}
		}.start();
	}
	public static void refreshFile(File f) {
		deleteFile(f);
		createFile(f);
	}
}
