package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import controllers.JBActions;
import controllers.MainController;
import utils.Util;

public class JDSelectSize extends JDialog{

	private static final long serialVersionUID = 1L;
	private JLabel jlInfo;
	private JLabel jlSize;
	private JSpinner jsSize;
	private JButton jbAccept;
	private MainController mainController;
	
	public JDSelectSize(MainController mainController) {
		this.mainController = mainController;
		this.setTitle(ConstantsGUI.JD_SELECT_SIZE);
		this.setSize(ConstantsGUI.JD_SELECT_SIZE_WIDTH, ConstantsGUI.JD_SELECT_SIZE_HEIGHT);
		this.setLayout(new GridBagLayout());
		this.setModal(true);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.WHITE);
		this.	setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.MAIN_ICON)).getImage());
		init();
	}
	
	private void init() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 10, 10, 10);
		Util.generateBasicGrid(this, gbc);
		
		jlInfo = new JLabel(ConstantsGUI.JL_INFO_SELECT_SIZE);
		jlInfo.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 30));
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 7;
		this.add(jlInfo, gbc);
		
		jlSize = new JLabel(ConstantsGUI.JL_SIZE);
		jlSize.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 22));
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 4;
		this.add(jlSize, gbc);
		
		jsSize = new JSpinner();
		gbc.gridx = 7;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 4;
		this.add(jsSize, gbc);
		
		jbAccept = new JButton(ConstantsGUI.JB_ACCEPT);
		jbAccept.setActionCommand(JBActions.ACCEPT_SIZE.toString());
		jbAccept.addActionListener(mainController);
		gbc.gridx = 4;
		gbc.gridy = 4;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		this.add(jbAccept, gbc);
	}
	
	public int getSizeFile() {
		return (int) (jsSize.getValue());
	}
}
