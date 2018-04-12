package models;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import exceptions.ExceptionNodeNotFound;

public class ManagerFiles implements FilenameFilter{

	private TreeN<String> treeFiles;
	private ArrayList<String> filesFound;

	public ManagerFiles() {
		filesFound = new ArrayList<String>();
	}

	public void initTree(String folder) {
		treeFiles = new TreeN<String>(folder);
	}

	public void add(String folder, String newInfo) throws ExceptionNodeNotFound {
		NodeTN<String> folderFather = treeFiles.searchNode(folder);
		treeFiles.addNode(folderFather, newInfo);
	}

	public void obtainFilesInMainFolder(File fileFolderMain) {
		File[] files = fileFolderMain.listFiles();
		for (File file: files) {
			if (file.isDirectory()) {
				obtainFilesInMainFolder(file);
			}else {
				filesFound.add(file.getName());
			}
		}
	}

	public void printFilesFound() {
		if (!filesFound.isEmpty()) {
			System.out.println("Subcarpetas");
			for (String file: filesFound) {
				System.out.println(file);								
			}
		}
	}

	public TreeN<String> getTreeFiles() {
		return treeFiles;
	}

	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(name);
	}	
}