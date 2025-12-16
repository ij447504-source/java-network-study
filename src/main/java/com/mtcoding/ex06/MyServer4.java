package com.mtcoding.ex06;

import com.google.gson.Gson;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer4 extends Object{
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(20000); //1. 서버소켓을 만든다
            Socket socket = ss.accept(); //2. 포트를 넣는다 ex.20000, while돌면서 지켜봄

            //읽기 버퍼
            Scanner sc = new Scanner(socket.getInputStream());

            //쓰기 버퍼
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            while(true){ //클라이언트가 주는 메세지 계속 와일돌면서 출력
                String line = sc.nextLine(); //String line은 . 클래스가 안돼서 오브젝트로 변경필요
                Gson gson = new Gson();
                Person p = gson.fromJson(line, Person.class); //타입을 바꿔서 Person에 넣어줌
                //문자열은 파싱이 안돼서 지금까지의 과정을 거친것임.

                System.out.println(p.getNo());
                System.out.println(p.getName());
                System.out.println(p.getAge());
                System.out.println(p.getHobby().get(0));//축구
                System.out.println(p.getHobby().get(1));//농구


                //age > 18 성인
                //age <= 18 미성년자
                if (p.getAge() > 18){
                    pw.println("성인");
                }else pw.println("미성년자");

            }
            //메인끄면 꺼지니간 굳이 클로즈만들필요없음
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
