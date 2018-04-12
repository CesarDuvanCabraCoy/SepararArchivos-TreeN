package models;

import exceptions.ExceptionNodeNotFound;

public class TreeN<T> {

	private NodeTN<T> root;
	
	public TreeN(T info) {
		this.root = createNode(info);
	}
	
	private NodeTN<T> createNode(T info) {
		return new NodeTN<T>(info);
	}
	
	public void addNode(NodeTN<T> father, T infoNewNode) {
		NodeTN<T> newNode = createNode(infoNewNode);
		newNode.setFather(father);
		father.addNode(newNode);
	}
	
	public NodeTN<T> searchNode(T info) throws ExceptionNodeNotFound{
		return searchNode(info, root);
	}
	
	private NodeTN<T> searchNode(T info, NodeTN<T> parent) throws ExceptionNodeNotFound{
		if (info != parent.getInfo()) {
			for (NodeTN<T> child : parent.getChilds()) {
				for (int j = 0; j < parent.getChilds().size(); j++) {
					if (parent.getChilds().get(j).getInfo().equals(info)) {
						return parent.getChilds().get(j);
					}					
				}
				return searchNode(info, child);
			}
		}else {
			return parent;
		}
		throw new ExceptionNodeNotFound();
	}
	
	public NodeTN<T> getRoot() {
		return root;
	}
}