package com.mtcoding.ex01;

import java.io.IOException;
import java.io.InputStream;

public class Buf01 {
    public static void main(String[] args) {
        //1. 키보드와 컴퓨터가 Byte 스트림이 연결됨
        InputStream in = System.in; //1개만 입력받는 코드 (2) AA를 입력해도 1개만 받음

        //2. 바이트 읽기
        try {
            int n = in.read(); //키보드로 부터 입력대기 \n (엔터) 엔터키가 들어오는 순간 캐치하여 n에 값을 넣어줍니다
            System.out.println(n);//(1) A를 입력하였더니 10진수 65 출력
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
