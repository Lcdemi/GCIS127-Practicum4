package practicum;

public class Sleeper implements Runnable {
    public String message;
    public int index;

    public Sleeper(String message, int index) {
        this.message = message;
        this.index = index;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(this.index * 100);
        } catch (InterruptedException e) {}
        System.out.print(this.message.charAt(this.index));
    }

    public static void main(String[] args) throws InterruptedException {
        Sleeper t = new Sleeper("Threads", 0);
        new Thread(t).start();
        
        Sleeper h = new Sleeper("Threads", 1);
        new Thread(h).start();

        Sleeper r = new Sleeper("Threads", 2);
        new Thread(r).start();

        Sleeper e = new Sleeper("Threads", 3);
        new Thread(e).start();

        Sleeper a = new Sleeper("Threads", 4);
        new Thread(a).start();
        
        Sleeper d = new Sleeper("Threads", 5);
        new Thread(d).start();

        Sleeper s = new Sleeper("Threads", 6);
        new Thread(s).start();
        
        Thread.sleep(1000);
        System.out.print("!");
    }
    
}
