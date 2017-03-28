package edu.sdu.tree;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Created by Jax on 2017/3/27.
 */

public class ForeachTree {

    public static void frontForeach(BinaryTreeNode head){
        if (head == null){
            return;
        }
        System.out.print(head.value+" ");
        frontForeach(head.left);
        frontForeach(head.right);
    }

    public static void midForeach(BinaryTreeNode head){
        if (head == null){
            return;
        }
        midForeach(head.left);
        System.out.print(head.value+" ");
        midForeach(head.right);
    }

    public static void backForeach(BinaryTreeNode head){
        if (head == null){
            return;
        }
        backForeach(head.left);
        backForeach(head.right);
        System.out.print(head.value+" ");

    }

    public static void wideFirst(BinaryTreeNode head){
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(head);
        BinaryTreeNode last = head;
        BinaryTreeNode nlast = head;
        while (!queue.isEmpty()) {
            BinaryTreeNode tem = queue.poll();
            System.out.print(tem.value);
            if (tem.left != null){
                queue.add(tem.left);
                nlast = tem.left;
            }
            if (tem.right != null){
                queue.add(tem.right);
                nlast = tem.right;
            }
            if (tem.equals(last)){
                System.out.println();
                last = nlast;
            } else {
                System.out.print(" ");
            }
        }

    }
    public static String xlh(BinaryTreeNode head){
        String str = "";
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(head);
        str += head.value + "!";
        while (!queue.isEmpty()){
            BinaryTreeNode tem = queue.poll();
            if(tem.left != null) {
                queue.add(tem.left);
                str += tem.left.value + "!";
            } else{
                str += "#!";
            }
            if(tem.right != null) {
                queue.add(tem.right);
                str += tem.right.value + "!";
            } else{
                str += "#!";
            }
        }
        return str;
    }

    public static BinaryTreeNode fxlh(String str){
        String[] strs = str.split("!");
        BinaryTreeNode head = new BinaryTreeNode<Integer>(Integer.parseInt(strs[0]));
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(head);
        int point = 1;
        while(!queue.isEmpty()){
            BinaryTreeNode tem = queue.poll();
            if(!Objects.equals(strs[point], "#")){
                tem.left = new BinaryTreeNode<Integer>(Integer.parseInt(strs[point]));
                queue.offer(tem.left);
            }
            point++;
            if(!Objects.equals(strs[point], "#")){
                tem.right = new BinaryTreeNode<Integer>(Integer.parseInt(strs[point]));
                queue.offer(tem.right);
            }
            point++;
        }
        return head;
    }

    public static String frontXlh(BinaryTreeNode head){
        if(head == null){
            return "#!";
        }
        String str = "";
        str += head.value + "!";
        str += frontXlh(head.left);
        str += frontXlh(head.right);
        return str;
    }

    public static Queue frontFxlh(String str){
        String[] strs = str.split("!");
        Queue<String> strQueue = new LinkedList<>();
        for(String s : strs){
            strQueue.offer(s);
        }
        return strQueue;
    }
    public static BinaryTreeNode frontFxlh(Queue<String> strQueue){
        if(strQueue.isEmpty()){
            return null;
        }
        String str = strQueue.poll();
        if(str.equals("#")){
            return null;
        }
        BinaryTreeNode<Integer> head = new BinaryTreeNode<Integer>(Integer.parseInt(str));
        head.left = frontFxlh(strQueue);
        head.right = frontFxlh(strQueue);
        return head;

    }


    public static void main(String[] args){
        CreateTree createTree = new CreateTree();
        BinaryTreeNode head = createTree.create();
        System.out.println("前序");
        frontForeach(head);
        System.out.println();
        System.out.println("中序");
        midForeach(head);
        System.out.println();
        System.out.println("后序");
        backForeach(head);
        System.out.println("宽度");
        wideFirst(head);
        System.out.println("序列化");
        System.out.println(xlh(head));
        System.out.println("反序列化");
        wideFirst(fxlh(xlh(head)));
        System.out.println("前序序列化");
        System.out.println(frontXlh(head));
        System.out.println("前序反序列化");
        wideFirst(frontFxlh(frontFxlh(frontXlh(head))));
    }
}
