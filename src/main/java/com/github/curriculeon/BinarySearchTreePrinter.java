package com.github.curriculeon;

public class BinarySearchTreePrinter<Key extends Comparable<Key>, Value> {
    private final BinarySearchTree<Key, Value> bst;

    public BinarySearchTreePrinter(BinarySearchTree<Key, Value> bst) {
        this.bst = bst;
    }

    private String printInOrder(BinarySearchTreeNode<Key, Value> node, StringBuilder sb) {
        //while (bst.getRoot() )
        while (node != null){
            if (node.getLeft() != null){
                node = node.getLeft();
            }
            else if (node.getRight() != null){
                node = node.getRight();
            }
            else{
                sb.append(node.getKey());
                bst.delete(node.getKey());
            }
        }
        return sb.toString();
    }

    public boolean ShouldAdd(BinarySearchTreeNode<Key, Value> node, StringBuilder sb){
        String value = node.getKey().toString();
        return !sb.toString().contains(value);
    }

    private String printPreOrder(BinarySearchTreeNode<Key, Value> node, StringBuilder sb) {
        int limit = 0;
        while (limit < bst.size()){
            if (ShouldAdd(node, sb)) {// IF THE KEY IS NOT IN THE STRING
                sb.append(node.getKey()).append("\n");
                limit++;
            }
            if (node.getLeft() != null && ShouldAdd(node.getLeft(), sb)){//IF THERE IS A NEW VALUE TO THE LEFT
                node = node.getLeft();
            }
            else if (node.getRight() != null && ShouldAdd(node.getRight(), sb)){//IF THERE IS A NEW VALUE TO THE RIGHT
                node = node.getRight();
            }
            else{
                node = node.Previous();
            }
        }
        return sb.toString();
    }

    private String printPostOrder(BinarySearchTreeNode<Key, Value> node, StringBuilder sb) {
        return null; // TODO
    }

    public String printInOrder() {
        return printInOrder(bst.getRoot(), new StringBuilder());
    }

    public String printPreOrder() {
        return printPreOrder(bst.getRoot(), new StringBuilder());
    }

    public String printPostOrder() {
        return printPostOrder(bst.getRoot(), new StringBuilder());
    }
}
