package utils;

import java.util.regex.Pattern;

public class Util {
	
	public static String getExtension(String name) {
		String extension = "";
		int i = name.lastIndexOf('.');
		int p = Math.max(name.lastIndexOf('/'), name.lastIndexOf('\\'));
		if (i > p) {
		    extension =  name.substring(i+1);
		}
		return extension;
	}
	
	public static String getNameOnly(String file) {
		String separator = Pattern.quote(".");
		return file.split(separator)[0].toString();
	}
}