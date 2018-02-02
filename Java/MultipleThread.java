import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = "";
        int count = 0;


        System.out.println("Enter Number of Counters :");
        count = in .nextInt(); in .nextLine();

        Counter a[] = new Counter[count];

        for (int i = 0; i < count; i++) {

            System.out.println("Enter text for counter " + (i + 1) + " :");
            str = in .next();
            a[i] = new Counter(str);

        }
        try {
            for (int i = 0; i < count; i++) {
                a[i].t.join();
            }
            for (int i = 0; i < count; i++) {

                System.out.println("Counter " + (i + 1) + " Result :");
                a[i].display();
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}




import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Counter extends Thread {
    String data;
    public HashMap < Character, Integer > hs = new HashMap < Character, Integer > ();

    Thread t;
    Double s;
    Counter(String s) {
        this.data = s;

        t = new Thread(this, "c");

        t.start();
    }
    public void addList(Character ch) {
        Integer count = this.hs.get(ch);

        count = (count == null) ? 1 : count + 1;
        this.hs.put(ch, count);

    }
    @Override
    public void run() {
        try {
            char ch;

            for (int i = 0; i < data.length(); i++) {

                ch = data.charAt(i);
                if (Character.isAlphabetic(ch)) {
                    this.addList(ch);
                }
            }


            Thread.sleep(100);

        } catch (InterruptedException e) {

        }
    }
    public synchronized void display() {
        Set < Character > set = this.hs.keySet();
        char arr[] = new char[set.size()];


        int i = 0;
        char ch;
        for (Iterator it = set.iterator(); it.hasNext(); i++) {
            ch = (Character) it.next();
            arr[i] = ch;
        }
        Arrays.sort(arr);

        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ":" + this.hs.get(arr[i]) + " ");
        }
        System.out.println();
    }


}