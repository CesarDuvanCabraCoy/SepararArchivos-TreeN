package models;

import java.util.ArrayList;

public class NodeTN<T> {

	private T info;
	private ArrayList<NodeTN<T>> childs;
	private NodeTN<T> father;
	
	public NodeTN(T info) {
		this.info = info;
		childs = new ArrayList<>();
	}
	
	public void addNode(NodeTN<T> newNode) {
		childs.add(newNode);
	}
	
	public T getInfo() {
		return info;
	}
	
	public void setInfo(T info) {
		this.info = info;
	}
	
	public ArrayList<NodeTN<T>> getChilds() {
		return childs;
	}
	
	public void setChilds(ArrayList<NodeTN<T>> childs) {
		this.childs = childs;
	}

	public NodeTN<T> getFather() {
		return father;
	}

	public void setFather(NodeTN<T> father) {
		this.father = father;
	}

	@Override
	public String toString() {
		return "NodeTN [info=" + info + "]";
	}
}