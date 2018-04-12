package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import models.ManagerFiles;
import views.JFCFolder;
import views.MainWindow;

public class MainController implements ActionListener{

	private MainWindow mainWindow;
	private ManagerFiles managerFiles;
	private JFCFolder jfcFolder;
	private File file;

	public MainController() {
		managerFiles = new ManagerFiles();
		mainWindow = new MainWindow(this);
		jfcFolder = new JFCFolder(mainWindow);
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (JBActions.valueOf(e.getActionCommand())) {
		case SHOW_JFC_FOLDER:
			jfcFolder.showFileChooser();
			obtainFolder();
			break;

		default:
			break;
		}
	}

	private void obtainFolder() {
		file = jfcFolder.getFile();
		managerFiles.initTree(file.getName());
		System.out.println("Folder: " + managerFiles.getTreeFiles().getRoot().getInfo());
	}
}
