package practicum;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;

public class MathClient {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("localhost", 10234);
        Scanner sc = new Scanner(socket.getInputStream());
        PrintWriter pw = new PrintWriter(socket.getOutputStream());

        Random RNG = new Random();
        int operation = RNG.nextInt(3);
        String operator = "";
        if(operation == 0) {
            operator.equals("add");
        } else if(operation == 1) {
            operator.equals("sub");
        } else if(operation == 2) {
            operator.equals("mult");
        } else {
            operator.equals("div");
        }

        double value = RNG.nextDouble() * 100;
        pw.println(operator + value);
        pw.flush();

        String response = sc.nextLine();
        System.out.println(response);
        socket.close();
    }
}
