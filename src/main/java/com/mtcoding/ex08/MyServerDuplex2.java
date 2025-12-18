//package com.mtcoding.ex08;
//
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class MyServerDuplex2 {
//    public static void main(String[] args) {
//        try {
//            ServerSocket ss =new ServerSocket(2000);
//            System.out.println("[server] 대기중...");
//
//            Socket socket = ss.accept();
//            System.out.println("[server] 연결됨: "+socket.getInetAddress());
//
//            Scanner socketSc = new Scanner(socket.getInputStream());
//            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
//            Scanner keyboardSc = new Scanner(System.in);
//
//
//            Thread receiver = new Thread(() ->{
//                try {
//                    while (socketSc.hasNextLine()) {
//                        String line = socketSc.nextLine();
//                        System.out.println("[server][recv] " + line);
//
//                        if("quit".equalsIgnoreCase(msg)){
//                            try{socket.close(); } catch (Exception ignored) {}
//                            break;
//                        }
//                    }
//                } catch (Exception e) {
//                    System.out.println("[server] sender 종료: " + e.getMessage());
//                }
//            });
//
//            receiver.start();
//            sender.start();
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//}
