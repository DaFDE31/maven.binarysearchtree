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
            if (compare.getKey().equals(key)){
                return compare.getValue();
            }
            if (compare.getKey().compareTo(key) > 0){// IF the orginal is bigger
                compare = compare.getLeft();
            }
            else if (compare.getKey().compareTo(key) < 0){// IF the orginal is smaller
                compare = compare.getRight();
            }

        }

        return null;
    }


    private BinarySearchTreeNode<Key, Value> put(BinarySearchTreeNode<Key, Value> x, Key key, Value value) {
        size++;
        if (key == null || value == null){
            throw new NullPointerException();
        }
        if (root == null){
            x = new BinarySearchTreeNode<>(key, value);
        }
        else{
            while (root != null){
                if (root.getKey().compareTo(key) < 0){
                    if (root.getRight() == null){
                        root.setRight(new BinarySearchTreeNode<>(key, value));
                        break;
                    }
                    root = root.getRight();
                }
                else if (root.getKey().compareTo(key) > 0){
                    if (root.getLeft() == null){
                        root.setLeft(new BinarySearchTreeNode<>(key, value));
                        break;
                    }
                    root = root.getLeft();
                }
                else{
                    root.setValue(value);
                    break;
                }
            }
        }
        return x;
    }



    private BinarySearchTreeNode<Key, Value> min(BinarySearchTreeNode<Key, Value> x) {
        while (root.getLeft() != null){
            root = root.getLeft();
        }
        return root;
    }

    private BinarySearchTreeNode<Key, Value> max(BinarySearchTreeNode<Key, Value> x) {
        while (root.getRight() != null){
            root = root.getRight();
        }
        return root;
    }

    private BinarySearchTreeNode<Key, Value> deleteMin(BinarySearchTreeNode<Key, Value> x) {
        while (root.getLeft() != null){
            root = root.getLeft();
        }
        if (root.getRight() == null){
            if (root.hasPrevious()){
                root = root.Previous();
                root.setLeft(null);
            }
            else
                root = null;
        }
        else
            root = root.getRight();

        return root;
    }

    private BinarySearchTreeNode<Key, Value> deleteMax(BinarySearchTreeNode<Key, Value> x) {
        size--;
        while (root.getRight() != null){
            root = root.getRight();
        }
        if (root.getLeft() == null){
            if (root.hasPrevious()){
                root = root.Previous();
                root.setRight(null);
            }
            else
                root = null;
        }
        else
            root = root.getLeft();

        return root;
    }

    private BinarySearchTreeNode<Key, Value> delete(BinarySearchTreeNode<Key, Value> x, Key key) {
        size--;
        while (root != null){
            if (root.getKey().equals(key)){
                if (root.getRight() != null){
                    root.getRight().setLeft(root.getLeft());
                    root = root.getRight();
                }
                else if (root.getLeft() != null){
                    root = root.getLeft();
                }
                return root;
            }
            if (root.getKey().compareTo(key) > 0){// IF the orginal is bigger
                root = root.getLeft();
            }
            else if (root.getKey().compareTo(key) < 0){// IF the orginal is smaller
                root = root.getRight();
            }

        }

        return null;
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
