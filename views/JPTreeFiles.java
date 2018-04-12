package views;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import models.NodeTN;

public class JPTreeFiles extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public void printJTree(NodeTN<String> treeN){
		DefaultMutableTreeNode root = searchBreadFirstaaa(treeN);
		JTree treePaint = new JTree(root);
		this.add(treePaint);
		this.repaint();
	}

	public static DefaultMutableTreeNode searchBreadFirstaaa(NodeTN<String> treeNario) {
		if(treeNario != null){
			DefaultMutableTreeNode father = new DefaultMutableTreeNode(treeNario.getInfo());
			printSonJTree(treeNario, father);
			return father;
		}
		
		return null;
	}
	
	private static void printSonJTree(NodeTN<String> auxRoot, DefaultMutableTreeNode father) {
		if(auxRoot != null){
			for (NodeTN<String> nodeAux : auxRoot.getChilds()) {
				DefaultMutableTreeNode sonAux = new DefaultMutableTreeNode(nodeAux.getInfo());	
				father.add(sonAux);
				printSonJTree(nodeAux, sonAux);
			}
		}
	}
	
	
}
