package views;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainWindow extends JFrame {

	public MainWindow() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.MAIN_ICON)).getImage());
		setName(ConstantsGUI.NAME_APP);
	}
	
	
}