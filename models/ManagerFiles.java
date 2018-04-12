package models;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import exceptions.ExceptionNodeNotFound;
import utils.Util;

public class ManagerFiles implements FilenameFilter{

	private TreeN<String> treeFiles;
	private ArrayList<File> filesFound;
	private ArrayList<String> subFolders;

	public ManagerFiles() {
		filesFound = new ArrayList<File>();
		subFolders = new ArrayList<String>();
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
				filesFound.add(file);
				verifySubFolderExist(file);
			}
		}
	}

	private void verifySubFolderExist(File file) {
		String extension = Util.getExtension(file.getName());
		if (subFolders.size() > 0) {
			for (int i = 0; i < subFolders.size(); i++) {
				if (!subFolders.contains(extension)) {
					subFolders.add(extension);
				}				
			}
		}else {
			subFolders.add(extension);
		}
	}
	
	public void createNodesBySize(String size) {
		for (NodeTN<String> nodeExtension: treeFiles.getRoot().getChilds()) {
			nodeExtension.addNode(new NodeTN<String>(ConstantsMOD.FOLDER_LESS + size));
			nodeExtension.addNode(new NodeTN<String>(ConstantsMOD.FOLDER_HIGHER + size));
		}
	}
	
	public void addSubFolders() {
		if (!subFolders.isEmpty()) {
			for (String subFolder: subFolders) {
				treeFiles.addNode(treeFiles.getRoot(), subFolder);							
			}
		}
	}
	
	public void addFilesToCorrespondingFolder(int size) throws ExceptionNodeNotFound {
		if (!filesFound.isEmpty()) {
			for (File file : filesFound) {
				NodeTN<String> father = treeFiles.searchNode(Util.getExtension(file.getName()));
				if (Util.calculateSizeFile(file) <= size) {
					treeFiles.addNode(father.getChilds().get(0), Util.getNameOnly(file.getName()));
				}else {
					treeFiles.addNode(father.getChilds().get(1), Util.getNameOnly(file.getName()));
				}
			}
		}
	}
	
	public void printSubFolders() {
		if (!subFolders.isEmpty()) {
			System.out.println("-------------Subcarpetas--------");
			for (int i = 0; i < subFolders.size(); i++) {
				System.out.println(subFolders.get(i));				
			}
		}
	}

	public void printFilesFound() {
		if (!filesFound.isEmpty()) {
			System.out.println("Subcarpetas");
			for (File file: filesFound) {
				System.out.println(file.getName());								
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