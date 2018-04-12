package views;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import controllers.MainController;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTBMain jtbMain;
	private MainController mainController;

	public MainWindow(MainController mainController) {
		this.mainController = mainController;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.MAIN_ICON)).getImage());
		setName(ConstantsGUI.NAME_APP);
		setLayout(new BorderLayout());
		init();
		this.setVisible(true);
	}
	
	private void init() {
		jtbMain = new JTBMain(mainController);
		this.add(jtbMain, BorderLayout.NORTH);
	}
}