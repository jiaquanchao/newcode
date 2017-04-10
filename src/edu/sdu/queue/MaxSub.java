package edu.sdu.queue;

import java.util.*;

/**
 * Created by Jax on 2017/4/9.
 */
public class MaxSub {

    //8
    //4 3 5 4 3 3 6 7
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = 3;
        int num = sc.nextInt();
        int[] ints = new int[num];
        LinkedList<Integer> linkedList = new LinkedList<>();
        int index = 0;
        int[] res = new int[num - w + 1];
        for (int i = 0; i < num; i ++) {
            ints[i] = sc.nextInt();
            while (!linkedList.isEmpty() && ints[linkedList.peekLast()] < ints[i]) {
                linkedList.pollLast();
            }
            linkedList.addLast(i);
            if (linkedList.peekFirst() <= i - w) {
                linkedList.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = ints[linkedList.peekFirst()];
            }
        }
        System.out.println(Arrays.toString(res));


    }

}
