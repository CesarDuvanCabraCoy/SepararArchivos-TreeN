package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import exceptions.ExceptionNodeNotFound;
import models.ManagerFiles;
import views.JDSelectSize;
import views.JFCFolder;
import views.MainWindow;

public class MainController implements ActionListener{

	private MainWindow mainWindow;
	private ManagerFiles managerFiles;
	private JFCFolder jfcFolder;
	private JDSelectSize jdSelectSize;
	private File file;

	public MainController() {
		managerFiles = new ManagerFiles();
		mainWindow = new MainWindow(this);
		jfcFolder = new JFCFolder(mainWindow);
		jdSelectSize = new JDSelectSize(this);
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (JBActions.valueOf(e.getActionCommand())) {
		case SHOW_JFC_FOLDER:
			jfcFolder.showFileChooser();
			obtainFolder();
			jdSelectSize.setVisible(true);
			break;
		case ACCEPT_SIZE:
			getSize();
			break;
		default:
			break;
		}
	}

	private void getSize() {
		int size = jdSelectSize.getSizeFile();
		managerFiles.createNodesBySize(String.valueOf(size));
		jdSelectSize.setVisible(false);
		try {
			managerFiles.addFilesToCorrespondingFolder(size);
		} catch (ExceptionNodeNotFound e) {
			e.printStackTrace();
		}
		mainWindow.paintTree(managerFiles.getTreeFiles().getRoot());
	}

	private void obtainFolder() {
		file = jfcFolder.getFile();
		managerFiles.initTree(file.getName());
		System.out.println("Folder: " + managerFiles.getTreeFiles().getRoot().getInfo());
		managerFiles.obtainFilesInMainFolder(file);
		managerFiles.addSubFolders();
	}
}
