package com.mtcoding.ex06;

import com.google.gson.Gson;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class MyClient4 {
    public static void main(String[] args) {


        try {
            Socket socket = new Socket("127.0.0.1", 20000);

            //키보드로 받는 값 삭제

            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            Scanner socketSc = new Scanner(socket.getInputStream());


            //여기 있는 키보드 값도 삭제
            Person person = new Person(1, "홍길동", 17, Arrays.asList("축구", "농구"));
            Gson gson = new Gson();
            String json = gson.toJson(person); //new Person 오브젝트를 String json 문자열로 변경
            //gson.toJson(person); 매서드의 책임, Person person을 타입 변환해주는 것
            pw.println(json); //json 형태로 만들어서 변환해줄게!
            String recv = socketSc.nextLine();
            System.out.println("서버로부터 받은 메세지 : " + recv);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
