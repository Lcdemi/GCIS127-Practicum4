package practicum;

import java.util.Random;

public class Person extends Room implements Runnable{
    public String name;
    public Room room;

    public Person(String name, Room room) {
        this.name = name;
        this.room = room;
    }

    @Override
    public void run() {
        Random RNG = new Random();
        if(hasRoom()) {
            synchronized(room) {
                enter();
                System.out.println(name + " has entered the room");
                try {
                    Thread.sleep((RNG.nextInt(4) + 1) * 1000); //seconds waiting in room
                } catch (InterruptedException e) {}
                exit();
                System.out.println(name + " has left the room");
                room.notifyAll();
            }
        } else {
            try {
                room.wait();
            } catch (InterruptedException e) {}
        }
    }

    public static void main(String[] args) {
        Room room = new Room();
        Person p1 = new Person("Angela", room);
        Person p2 = new Person("Baron", room);
        Person p3 = new Person("Cindy", room);
        Person p4 = new Person("Dave", room);
        Person p5 = new Person("Enoch", room);
        Person p6 = new Person("Felicia", room);
        Person p7 = new Person("Gabe", room);
        Person p8 = new Person("Hannah", room);
        Person p9 = new Person("Izzy", room);
        Person p10 = new Person("Jabroni", room);
        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(p3).start();
        new Thread(p4).start();
        new Thread(p5).start();
        new Thread(p6).start();
        new Thread(p7).start();
        new Thread(p8).start();
        new Thread(p9).start();
        new Thread(p10).start();
        
    }
    
}
