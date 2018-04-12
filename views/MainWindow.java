package views;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import controllers.MainController;
import models.NodeTN;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTBMain jtbMain;
	private JPTreeFiles jpTreeFiles;
	private MainController mainController;

	public MainWindow(MainController mainController) {
		this.mainController = mainController;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(ConstantsGUI.WIDTH_JF, ConstantsGUI.HEIGHT_JF);
		setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.MAIN_ICON)).getImage());
		setName(ConstantsGUI.NAME_APP);
		setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		init();
		this.setVisible(true);
	}
	
	private void init() {
		jtbMain = new JTBMain(mainController);
		this.add(jtbMain, BorderLayout.NORTH);
		
		jpTreeFiles = new JPTreeFiles();
		this.add(jpTreeFiles, BorderLayout.CENTER);
	}
	
	public void paintTree(NodeTN<String> root) {
		jpTreeFiles.printJTree(root);
	}
}