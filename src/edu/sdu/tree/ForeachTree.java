package edu.sdu.tree;


/**
 * Created by Jax on 2017/3/27.
 */

public class ForeachTree {

    public static void frontForeach(BinaryTreeNode head){
        if (head == null){
            return;
        }
        System.out.println(head.value+" ");
        frontForeach(head.left);
        frontForeach(head.right);
    }

    public static void midForeach(BinaryTreeNode head){
        if (head == null){
            return;
        }
        midForeach(head.left);
        System.out.println(head.value);
        midForeach(head.right);
    }

    public static void main(String[] args){
        CreateTree createTree = new CreateTree();
        BinaryTreeNode<Integer> head = createTree.create();
        midForeach(head);
    }
}
