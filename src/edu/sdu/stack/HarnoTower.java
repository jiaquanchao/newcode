package edu.sdu.stack;

import java.util.Scanner;

/**
 * Created by Jax on 2017/3/28.
 */
public class HarnoTower {
    //递归
    public static int harno1(int num, String left, String mid, String right){
        if(num < 1) {
            return 0;
        }
        return process(num, left, mid, right, left, right);
    }

    public static int process(int num, String left, String mid, String right, String from, String to){
        if(num == 1){
            if(from.equals(mid) || to.equals(mid)) {
                System.out.println(from + " -> " + to);
                return 1;
            } else {
                System.out.println(from + " -> " + mid);
                System.out.println(mid + " -> " + to);
                return 2;
            }
        }
        if(from.equals(mid) || to.equals(mid)){
            String another = (from.equals(left) || to.equals(left)) ? right : left;
            int part1 = process(num-1, left, mid, right, from, another);
            int part2 = 1;
            System.out.println(from + " -> " + to);
            int part3 = process(num - 1, left, mid, right, another, to);
            return part1 + part2 + part3;
        } else {
            int part1 = process(num - 1, left, mid, right, from, to);
            int part2 = 1;
            System.out.println(from + " -> " + mid);
            int part3 = process(num - 1, left, mid, right, to, from);
            int part4 = 1;
            System.out.println(mid + " -> " + to);
            int part5 = process(num - 1, left, mid, right, from, to);
            return part1 + part2 + part3 + part4;
        }
    }

    public static void main(String[] args) {
        System.out.println(harno1(3, "left", "mid", "right"));
    }
}




class Main{

    public static int reverse(int a){
        boolean flag = false;
        int res = 0;
        while(a/10 > 0){
            if(a % 10 != 0){
                flag = true;
            }
            if(flag){
                res = (a % 10 + res * 10);
            }
            a = a/10;
        }
        return res * 10 + a;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(reverse(a)+ reverse(b));
    }
}
