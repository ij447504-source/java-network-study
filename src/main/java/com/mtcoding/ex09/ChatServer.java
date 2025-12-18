package com.mtcoding.ex09;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

class ClientThread implements Runnable {
    //ClientThread 해당스레드가 소켓이랑 버퍼를 다 담고 있는것_그림에서 빨간 동그라미
    Socket socket;
    PrintWriter sender;
    Scanner receiver;

    public ClientThread(Socket socket, PrintWriter sender, Scanner receiver) {
        this.socket = socket;
        this.sender = sender;
        this.receiver = receiver;
    }

    @Override
    public void run() {

        while (true) {
// 새로운 스레드 대기중
            String msg = receiver.nextLine();
            System.out.println("클라이언트로 부터 메시지 받음");
            for (ClientThread t : ChatServer.boxes) {
                //박스돌면서 자기자신한테만 안 보내면 됨
                System.out.println("전체 전송됨");
                t.sender.println(msg);
            }
        }

    }
}

public class ChatServer {

    static List<ClientThread> boxes = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        try {
            // 1. 초기화
            //클라이언트 개수만큼 BR BR 생성
            ServerSocket ss = new ServerSocket(50000);//accept(); 호출
            while (true) {//메인스레드는 클라이언트 요청이 오면 아랫것들을 만든다
                Socket socket = ss.accept(); // main 스레드 대기
                System.out.println("클라이언트 연결 완료!");
                //버퍼생성
                PrintWriter sender = new PrintWriter(socket.getOutputStream(), true);
                Scanner receiver = new Scanner(socket.getInputStream());
                //박스객체에 담기
                ClientThread t1 = new ClientThread(socket, sender, receiver);
                //컬렉션 담기
                boxes.add(t1);
                //스레드 실행
                new Thread(t1).start();
                //작업단위를 부른 것 뿐
                // 작업단위 Q를 넘겨주어야해서 위쪽 오버로드로 넘김
                //런이라는 작업단위가 생기고 스레드가 전담한다.
                //스레드는 자체상태를 가진다. 컬렉션에서 안 땡겨도됨 socket, sender, receiver
                System.out.println("새로운 스레드 생성됨");
            }

        } catch (Exception e) {
            System.out.println("서버 오류 : " + e.getMessage());
        }

    }
}