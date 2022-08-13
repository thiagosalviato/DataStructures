package BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.addict(10);
        tree.addict(5);
        tree.InOrder(tree.getRoot());
    }
}
