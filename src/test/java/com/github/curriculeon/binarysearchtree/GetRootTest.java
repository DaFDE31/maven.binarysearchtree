package com.github.curriculeon.binarysearchtree;

import com.github.curriculeon.BinarySearchTree;
import org.junit.Assert;
import org.junit.Test;

public class GetRootTest {
    @Test
    public void testGetRootOnEmptyTree() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        Assert.assertNull(bst.getRoot());
    }

    @Test
    public void testGetRootOnSingleElementTree() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(5, "Five");
        Assert.assertEquals(bst.getRoot().getKey().intValue(), 5);
        Assert.assertEquals(bst.getRoot().getValue(), "Five");
    }

    @Test
    public void testGetRootOnMultiElementTree() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(5, "Five");
        bst.put(3, "Three");
        bst.put(7, "Seven");
        bst.put(1, "One");
        Assert.assertEquals(bst.getRoot().getKey().intValue(), 5);
        Assert.assertEquals(bst.getRoot().getValue(), "Five");
    }

    @Test
    public void testGetRootAfterDelete() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(5, "Five");
        bst.put(3, "Three");
        bst.put(7, "Seven");
        bst.put(1, "One");
        bst.delete(5);
        Assert.assertEquals(bst.getRoot().getKey().intValue(), 7);
        Assert.assertEquals(bst.getRoot().getValue(), "Seven");
    }

}
