package com.mtcoding.ex04;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer2 {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(20000); //1. 서버소켓을 만든다
            Socket socket = ss.accept(); //2. 포트를 넣는다 ex.20000, while돌면서 지켜봄
            //새로운 소켓이 만들어진다.

            InputStream in = socket.getInputStream();
            InputStreamReader ir = new InputStreamReader(in);//문자캐스팅도구,
            BufferedReader br = new BufferedReader(ir); //토끼에 모자 씌우기

            while(true){ //클라이언트가 주는 메세지 계속 와일돌면서 출력
                String line = br.readLine(); //엔터키까지 읽기
                System.out.println("[server] "+line);
            }
            //메인끄면 꺼지니간 굳이 클로즈만들필요없음
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
