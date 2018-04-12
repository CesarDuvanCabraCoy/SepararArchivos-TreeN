package utils;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.util.regex.Pattern;

import javax.swing.JLabel;

import views.ConstantsGUI;

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
	
	public static void generateBasicGrid(Container comp, GridBagConstraints gbc){
		gbc.weightx = 1;
		for (int i = 0; i < ConstantsGUI.COLUMNS_NUMBER; i++) {
			gbc.gridx = i;
			comp.add(new JLabel(""), gbc);
		}
	}
}