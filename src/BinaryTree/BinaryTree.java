package BinaryTree;

import BinaryTree.Element;

public class BinaryTree<Type> {

    private Element<Type> root;

    public BinaryTree(){
        this.root = null;
    }

    public void addict(Type value){
        Element<Type> newElement = new Element<Type>(value);
        if(root == null){
            this.root = newElement;
        }else {
            Element<Type> current = this.root;
            while (true){
                if (current.getValue().compareTo(newElement.getValue())) {
                    if(current.getRight() != null){
                        current = current.getRight();
                    }else {
                        current.setRight(newElement);
                    }
                } else {
                    if (current.getLeft() != null){
                        current = current.getLeft();
                    } else{
                        current.setLeft(newElement);
                        break;
                    }
                }
            }
        }
    }

    public void InOrder(Element<Type> current){
        if(current != null) {
            InOrder(current.getLeft());
            System.out.println(current);
            InOrder(current.getRight());
        }
    }

    public void PreOrder(Element<Type> current){
        if(current != null) {
            System.out.println(current.getValue());
            PreOrder(current.getLeft());
            PreOrder(current.getRight());
        }
    }

    public void AfterOrder(Element<Type> current){
        if(current != null) {
            PreOrder(current.getLeft());
            PreOrder(current.getRight());
            System.out.println(current.getValue());
        }
    }

    public Element<Type> getRoot() {
        return root;
    }
}
