import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double x, y, z;

        System.out.println("Enter the Degree for Sin : ");
        x = in .nextDouble();
        System.out.println("Enter the Degree for Cos : ");
        y = in .nextDouble();
        System.out.println("Enter the Degree for Tan : ");
        z = in .nextDouble();


        double p;

        SineClass a = new SineClass(x);
        CosClass b = new CosClass(y);
        TanClass c = new TanClass(z);
        try {
            a.t.join();
            b.t.join();
            c.t.join();

            p = (a.s + b.s + c.s);

            String format = String.format("%.2f", p);
            System.out.print("Sum of sin, cos, tan = ");

            System.out.println(format);

        } catch (Exception e) {

        }


    }

}


public class SineClass implements Runnable {
    Double x;
    Thread t;
    Double s;
    SineClass(Double x) {
        this.x = x;
        t = new Thread(this, "sinClass");

        t.start();
    }

    public void run() {
        try {
            this.s = Math.sin(Math.toRadians(x));
            Thread.sleep(1000);

        } catch (InterruptedException e) {

        }
    }
}


public class CosClass implements Runnable {
    Double x;
    Thread t;
    Double s;
    CosClass(Double x) {
        this.x = x;
        t = new Thread(this, "CosClass");

        t.start();
    }

    public void run() {
        try {
            this.s = Math.cos(Math.toRadians(x));
            Thread.sleep(1000);

        } catch (InterruptedException e) {

        }

    }
}

public class TanClass implements Runnable {
    Double x;
    Thread t;
    Double s;
    TanClass(Double x) {
        this.x = x;
        t = new Thread(this, "sinClass");

        t.start();
    }
    // This is the entry point for thread.
    public void run() {
        try {
            this.s = Math.tan(Math.toRadians(x));
            Thread.sleep(1000);

        } catch (InterruptedException e) {

        }

    }
}