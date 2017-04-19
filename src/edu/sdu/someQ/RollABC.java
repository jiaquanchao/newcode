package edu.sdu.someQ;

/**
 * Created by jax on 2017/4/18.
 */
public class RollABC {
    private static Object object = new Object();
    Thread a = new Thread(new Roll("A"));
    Thread b = new Thread(new Roll("B"));
    Thread c = new Thread(new Roll("C"));


}

class Roll implements Runnable {

    private String name;
    public Roll(String name){
        this.name = name;
    }
    @Override
    public void run() {
        if (name.equals("C")) {
            System.out.println(name);
        } else {
            System.out.print(name);
        }
    }
}
