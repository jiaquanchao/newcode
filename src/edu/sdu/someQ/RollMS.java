package edu.sdu.someQ;

/**
 * Created by jax on 2017/4/18.
 */
public class RollMS {
    private static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable(){
            public void run() {
                for (int j = 0; j < 5; j ++) {
                    synchronized (object) {
                        for (int i = 0; i < 10; i++) {
                            System.out.println("sub: " + i);
                        }
                        object.notify();
                        try {
                            object.wait();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                }
            }
        }).start();
        for(int i = 0; i < 5; i ++) {

            synchronized (object){
                object.wait();
                System.out.println("main: " + i);
                object.notify();
            }

        }
    }
}
