package com.mtcoding.ex11;

import com.google.gson.Gson;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class UserApp {
    public static void main(String[] args) {
        try{
           // 1. 다운로드(Repository download() 3단계
            // 1. 소켓 연결완료
            String json = Repository.download("https://jsonplaceholder.typicode.com/users/1");
            //static 이라 new를 소환할 필요없음

           // 2. 다운로드 확인
            System.out.println("정상적으로 다운로드 됐습니다");
           // 3. 오브젝트로 변환 ( json -> User) - gson필요
            Gson gson = new Gson(); //Gson 문자열을 자바로 변경하는 것이야, 이 친구가 들고 있는 함수를 쓰기 위해
            User u = gson.fromJson(json, User.class);


           // 4. 변환 확인
            System.out.println("변환 확인이 적상작동했습니다"); //User 객체가 잘 옮겨졌는지 확인하기 위해 사용
           // 5. 콘솔에 유저 정보 출력 (for문 말고 sout 하나씩)
            System.out.println(u.getId());
            System.out.println(u.getName());
            System.out.println(u.getUsername());
            System.out.println(u.getEmail());
            System.out.println(u.getPhone());
            System.out.println(u.getWebsite());
            System.out.println();
            System.out.println(u.getCompany().getName());
            System.out.println(u.getCompany().getCatchPhrase());
            System.out.println(u.getCompany().getBs());



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
