package edu.sdu.stack;

import java.util.Stack;

/**
 * Created by Jax on 2017/3/28.
 */
public class ReverseStack {

    public static int getTheLast(Stack<Integer> stack){
        int last = stack.pop();
        int tem = last;
        if(!stack.isEmpty()){
            tem = getTheLast(stack);
            stack.push(last);
        }
        return tem;
    }


    public static Stack<Integer> revers(Stack<Integer> stack){
        int last = getTheLast(stack);
        Stack tem = stack;
        if(!stack.isEmpty()){
            tem = revers(stack);
        }
        stack.push(last);
        return stack;
    }

    public static void main(String[] args){
        Stack stack = new Stack();
        for(int i = 1; i <= 100; i ++){
            stack.push(i);
        }
        Stack res = revers(stack);
        while(!res.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
