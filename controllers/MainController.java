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
		String size = String.valueOf(jdSelectSize.getSizeFile());
		managerFiles.createNodesBySize(size);
		jdSelectSize.setVisible(false);
	}

	private void obtainFolder() {
		file = jfcFolder.getFile();
		managerFiles.initTree(file.getName());
		System.out.println("Folder: " + managerFiles.getTreeFiles().getRoot().getInfo());
		managerFiles.obtainFilesInMainFolder(file);
		managerFiles.printFilesFound();
		managerFiles.addSubFolders();
		managerFiles.printSubFolders();
	}
}
