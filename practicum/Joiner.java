package practicum;

import java.util.ArrayList;

public class Joiner implements Runnable {
    public String message;
    public int index;
    public Thread previous;

    public Joiner(String message, int index, Thread previous) {
        this.message = message;
        this.index = index;
        this.previous = previous;
    }

    @Override
    public void run() {
        System.out.print(this.message.charAt(this.index));
    }

    public static void main(String[] args) throws InterruptedException {

        Joiner t = new Joiner("Threads", 0, null);
        Thread tThread = new Thread(t);
        tThread.start();
        if(t.getPrevious() != null) {
            tThread.join();
        }
        
        Joiner h = new Joiner("Threads", 1, tThread);
        Thread hThread = new Thread(h);
        hThread.start();
        if(h.getPrevious() != null) {
            hThread.join();
        }

        Joiner r = new Joiner("Threads", 2, hThread);
        Thread rThread = new Thread(r);
        rThread.start();
        if(r.getPrevious() != null) {
            rThread.join();
        }

        Joiner e = new Joiner("Threads", 3, rThread);
        Thread eThread = new Thread(e);
        eThread.start();
        if(t.getPrevious() != null) {
            eThread.join();
        }

        Joiner a = new Joiner("Threads", 4, eThread);
        Thread aThread = new Thread(a);
        aThread.start();
        if(t.getPrevious() != null) {
            aThread.join();
        }

        Joiner d = new Joiner("Threads", 5, aThread);
        Thread dThread = new Thread(d);
        dThread.start();
        if(t.getPrevious() != null) {
            dThread.join();
        }

        Joiner s = new Joiner("Threads", 6, dThread);
        Thread sThread = new Thread(s);
        sThread.start();
        if(t.getPrevious() != null) {
            sThread.join();
        }
        
        System.out.print("!");
    }

    public Thread getPrevious() {
        return previous;
    }
    
}
