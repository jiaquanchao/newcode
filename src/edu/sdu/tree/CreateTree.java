package edu.sdu.tree;

/**
 * Created by Jax on 2017/3/27.
 */
public class CreateTree {
    // 不是平衡二叉树
    //             1
    //         /      \
    //        2        6
    //       /\       /\
    //      3  4     7  8
    //        /          \
    //       5            9
    //                   /
    //                 10
    public BinaryTreeNode create() {
        BinaryTreeNode<Integer> n1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> n6 = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> n7 = new BinaryTreeNode<>(7);
        BinaryTreeNode<Integer> n8 = new BinaryTreeNode<>(8);
        BinaryTreeNode<Integer> n9 = new BinaryTreeNode<>(9);
        BinaryTreeNode<Integer> n10 = new BinaryTreeNode<>(10);
        n1.left = n2;
        n1.right = n6;
        n2.left = n3;
        n2.right = n4;
        n4.left = n5;
        n6.left = n7;
        n6.right = n8;
        n8.right = n9;
        n9.left = n10;
        return n1;
    }
}
