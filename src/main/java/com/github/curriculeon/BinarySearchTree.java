package com.github.curriculeon;

import java.util.NoSuchElementException;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private BinarySearchTreeNode<Key, Value> root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    private Value get(BinarySearchTreeNode<Key, Value> x, Key key) {
        BinarySearchTreeNode<Key, Value> compare = root;
        while (compare != null){
            if (compare.getKey().compareTo(key) > 0){// IF the orginal is bigger
                compare = compare.getLeft();
            }
            else if (compare.getKey().compareTo(key) < 0){// IF the orginal is smaller
                compare = compare.getRight();
            }
            if (compare.getKey().equals(key)){
                return compare.getValue();
            }
        }

        return null;
    } // Might work but have to do put first

    private BinarySearchTreeNode<Key, Value> put(BinarySearchTreeNode<Key, Value> x, Key key, Value value) {
        size++;
        if (key == null || value == null){
            throw new NullPointerException();
        }
        if (root == null){
            x = new BinarySearchTreeNode<>(key, value);
        }
        else{
            BinarySearchTreeNode<Key, Value> compare = root;
            while (compare != null){
                if (compare.getKey().compareTo(key) < 0){
                    if (compare.getRight() == null){
                        compare.setRight(new BinarySearchTreeNode<>(key, value));
                        break;
                    }
                    compare = compare.getRight();
                }
                else if (compare.getKey().compareTo(key) > 0){
                    if (compare.getLeft() == null){
                        compare.setLeft(new BinarySearchTreeNode<>(key, value));
                        break;
                    }
                    compare = compare.getLeft();
                }
                else{
                    compare.setValue(value);
                    break;
                }
            }
        }
        return x;
    }

    private BinarySearchTreeNode<Key, Value> min(BinarySearchTreeNode<Key, Value> x) {
        return null; // TODO
    }

    private BinarySearchTreeNode<Key, Value> max(BinarySearchTreeNode<Key, Value> x) {
        return null; // TODO
    }

    private BinarySearchTreeNode<Key, Value> deleteMin(BinarySearchTreeNode<Key, Value> x) {
        size--;
        return null; // TODO
    }

    private BinarySearchTreeNode<Key, Value> deleteMax(BinarySearchTreeNode<Key, Value> x) {
        size--;
        return null; // TODO
    }

    private BinarySearchTreeNode<Key, Value> delete(BinarySearchTreeNode<Key, Value> x, Key key) {
        size--;
        return null; // TODO
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public BinarySearchTreeNode<Key, Value> getRoot() {
        return root;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table is empty");
        }
        return min(root).getKey();
    }

    public Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table is empty");
        }
        return max(root).getKey();
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table is empty");
        }
        root = deleteMin(root);
        size--;
    }

    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table is empty");
        }
        root = deleteMax(root);
        size--;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }
}
