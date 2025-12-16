package com.mtcoding.ex05;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer3 {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(20000); //1. 서버소켓을 만든다
            Socket socket = ss.accept(); //2. 포트를 넣는다 ex.20000, while돌면서 지켜봄

            //읽기 버퍼
            Scanner sc = new Scanner(socket.getInputStream());

            //쓰기 버퍼
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            while(true){ //클라이언트가 주는 메세지 계속 와일돌면서 출력
                String line = sc.nextLine(); //엔터키까지 읽기
                System.out.println("[server] "+line);
                pw.println("ok");
            }
            //메인끄면 꺼지니간 굳이 클로즈만들필요없음
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
