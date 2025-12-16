package com.mtcoding.ex05;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MyClient3 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 20000);

            Scanner sc = new Scanner(System.in);

            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            Scanner socketSc = new Scanner(socket.getInputStream()
            );

            while(true){
                String keyboardData = sc.nextLine();
                pw.println(keyboardData); //ln이 \n이 넣어주고, autoFlush가 된다.
                String recv = socketSc.nextLine();
                System.out.println("서버로부터 받은 메세지 : "+recv);

            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
