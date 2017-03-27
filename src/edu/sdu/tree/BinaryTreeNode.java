package edu.sdu.tree;

/**
 * Created by Jax on 2017/3/27.
 */
public class BinaryTreeNode<T> {
    public T value;
    public BinaryTreeNode left = null;
    public BinaryTreeNode right = null;
    public BinaryTreeNode(T value){
        this.value = value;
    }
}
