package edu.sdu.digui;

/**
 * Created by Jax on 2017/3/29.
 */
public class GetDp {
    public static int getMax(int[] arr){
        int max=arr[0];
         for(int i=1;i<arr.length;i++){
             if(arr[i]>max){
                 max=arr[i];
             }
         }
         return max;
    }
    public static int[] get1(int[] ints){
        int[] dp = new int[ints.length];
        for (int i = 0; i < ints.length; i ++){
            dp[i] = 1;
            for (int j = 0; j < i; j ++){
                if(ints[j] < ints[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    public static void printDp(int[] a, int[] ints, int dpLength){
        int point = 0 ;
        String str = "";
        for(int i = 0; i < ints.length; i ++){
            if(ints[i] == dpLength){
                point = i;
                break;
            }
        }
        str = a[point] + "";
        dpLength --;
        for(int i = point; i >= 0 && dpLength > 0; i --){
            if(ints[i] == dpLength){
                str = a[i] + " " + str;
                dpLength --;
            }
        }
        System.out.println(str);
    }
    public static void main(String[] args) {
        int[] ints = new int[]{1,4,5,2,1,2,3,4};
        int[] res = get1(ints);
        System.out.println(getMax(res));
        printDp(ints, res, 4);

    }
}
