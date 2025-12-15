package com.mtcoding.ex01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Buf04 {
    public static void main(String[] args) {
        // 1. 바이트 스트림 연결
        OutputStream out = System.out; // 모니터 연결
        OutputStreamWriter ow = new OutputStreamWriter(out); //문자를 바이트로 저장
        BufferedWriter bw = new BufferedWriter(ow); //(1) 모아서 한번에 보내는 코드
        try {
            bw.write("ABC"); //모니터로 보내는 게 아니라 버퍼에만 저장
            bw.flush(); // (2) 버퍼를 비워라(꽉 찼을 때) 또는 close 사용가능
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
