package com.github.curriculeon;

public class BinarySearchTreeNode<Key extends Comparable<Key>, Value> {
    private BinarySearchTreeNode<Key, Value> Left;
    private BinarySearchTreeNode<Key, Value> Right;
    private BinarySearchTreeNode<Key, Value> Previous;

    private Key key;
    private Value value;

    public BinarySearchTreeNode(Key key, Value value) {
        setLeft(null);
        setRight(null);
        setKey(key);
        setValue(value);
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public BinarySearchTreeNode<Key, Value> getLeft() {
        return Left;}

    public void setLeft(BinarySearchTreeNode<Key, Value> left) {
        Left = left;
        if (left != null)
        left.setPrevious(this);
    }

    public BinarySearchTreeNode<Key, Value> getRight() {
        return Right;
    }

    public void setRight(BinarySearchTreeNode<Key, Value> right) {
        Right = right;
        if (right != null)
        right.setPrevious(this);
    }

    public BinarySearchTreeNode<Key, Value> Previous() {
        return Previous;
    }

    public void setPrevious(BinarySearchTreeNode<Key, Value> previous) {
        Previous = previous;
    }

    public boolean hasPrevious(){
        return Previous != null;
    }

    @Override
    public String toString() {
        return "(" + getKey() + ", " + getValue() + ")";
    }
}

