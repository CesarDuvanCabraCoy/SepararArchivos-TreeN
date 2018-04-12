package views;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;

public class JFCFolder {

	private JFileChooser jfcFolder;
	private Component comp;
	
	public JFCFolder(Component comp) {
		this.comp = comp;
		jfcFolder = new JFileChooser();
		jfcFolder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	}
	
	public void showFileChooser(){
		jfcFolder.showOpenDialog(comp);
	}
	
	public File getFile() {
		return jfcFolder.getSelectedFile();
	}
	
}
