package com.mtcoding.ex09;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.0.99", 10000);
            //읽고 쓰기할거라 스레드2
            Scanner keyboard = new Scanner(System.in);
            Scanner receiver = new Scanner(socket.getInputStream());
            PrintWriter sender = new PrintWriter(socket.getOutputStream(), true);

            //1. 송신 스레드, 키보드로부터 받아서 써야함
            new Thread(() -> {
                while(true){
                    String msg = keyboard.nextLine();
                    sender.println(msg);
                }//스레드의 종료는 와일의 조건이 결정
            }).start();

            // 2. 읽기 스레드
            new Thread(() -> {
                while(true){
                    String msg = receiver.nextLine();
                    System.out.println("서버로 부터 메시지 받음");
                    System.out.println("진짜 받음?");
                    System.out.println(msg);
                }

            }).start();

        } catch (Exception e) {
            System.out.println("클라이언트 오류 : "+e.getMessage());
        }
    }
}