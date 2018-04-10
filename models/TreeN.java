package models;

import exceptions.ExceptionNodeNotFound;

public class TreeN<T> {

	private NodeTN<T> root;
	
	public TreeN(NodeTN<T> root) {
		this.root = root;
	}
	
	public void addNode(NodeTN<T> father, NodeTN<T> newNode) {
		newNode.setFather(father);
		father.addNode(newNode);
	}
	
	public NodeTN<T> searchNode(T info) throws ExceptionNodeNotFound{
		return searchNode(info, root);
	}
	
	private NodeTN<T> searchNode(T info, NodeTN<T> parent) throws ExceptionNodeNotFound{
		if (info != parent.getInfo()) {
			for (int i = 0; i < parent.getChilds().size(); i++) {
				for (int j = 0; j < parent.getChilds().size(); j++) {
					if (parent.getChilds().get(j).getInfo().equals(info)) {
						return parent.getChilds().get(j);
					}					
				}
				return searchNode(info, parent.getChilds().get(i));
			}
		}else {
			return parent;
		}
		throw new ExceptionNodeNotFound();
	}
}