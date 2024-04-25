package practicum;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MathServer implements Runnable {
    public ServerSocket server;
    public Scanner sc;
    public PrintWriter pw;
    public double result;

    public MathServer(int port) throws IOException {
        this.server = new ServerSocket(port);
        this.result = 0;
        while(true) {
            Socket client = server.accept();
            this.sc = new Scanner(client.getInputStream());
            this.pw = new PrintWriter(client.getOutputStream());
            Thread clientThread = new Thread();
            clientThread.start();
        }
    }

    public static void main(String[] args) throws IOException {
        new MathServer(10234);
    }

    @Override
    public void run() {
        String input = sc.nextLine();
        String[] requests = input.split(" ");
        if(requests[0].equals("add")) {
            System.out.println("RECEIVED ADD " + requests[1]);
            this.result = result + Double.parseDouble(requests[1]);
            pw.println("result " + result);
            pw.flush();
        } else if(requests[0].equals("sub")) {
            System.out.println("RECEIVED SUB " + requests[1]);
            this.result = result - Double.parseDouble(requests[1]);
            pw.println("result " + result);
            pw.flush();
        } else if(requests[0].equals("mul")) {
            System.out.println("RECEIVED MUL " + requests[1]);
            this.result = result * Double.parseDouble(requests[1]);
            pw.println("result " + result);
            pw.flush();
        } else if(requests[0].equals("div")) {
            if(requests[1].equals("0")) {
                System.out.println("RECEIVED DIV " + requests[1]);
                pw.println("error");
                pw.flush();
            } else {
                System.out.println("RECEIVED DIV " + requests[1]);
                this.result = result / Double.parseDouble(requests[1]);
                pw.println("result " + result);
                pw.flush();
            }
        } else {
            System.out.println("RECEIVED INVALID REQUEST");
            pw.println("error");
            pw.flush();
        }
    }
    
}
