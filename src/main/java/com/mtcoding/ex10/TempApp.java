package com.mtcoding.ex10;

import com.google.gson.Gson;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class TempApp {
    public static void main(String[] args) {
        try {
            // 1. ip와 port를 통해 소켓을 만들고 스트림을 연결한다.
            URL url = new URL("https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst?serviceKey=d36e07c26abc33f8702aa40645d0eb399b2ab126b2405394bbe45e2572b2a050&pageNo=1&numOfRows=1000&dataType=JSON&base_date=20251218&base_time=1200&nx=98&ny=75");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");//헤더에 버퍼쓸때 달라 

            // 2. 버퍼를 달아야한다.
            Scanner sc = new Scanner(conn.getInputStream());

            String json = "";
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                json = json + line;
            }
//            System.out.println(json);

            Gson gson = new Gson(); //Gson객체만들기
            //1. String타입의 Json을 -> Hello 오브젝트로 변경
            /**
             * 통신을 다운받을 때
             */
            Hello hello = gson.fromJson(json,Hello.class); //내부적으로 제네릭에 넣을건데 hello.class타입이라고 내가 알려주는 것
            //T1H의 온도를 알아내야함
            //내부클래스라서 아래처럼 <>이름쓴거임, 외부이름이면 item만 쓰면됨
            List<Hello.Response.Body.Items.Item> itemList = hello.getResponse().getBody().getItems().getItem();
            String temp = itemList.get(3).getObsrValue();
            System.out.println(temp);



            //2. Hello 오브젝트를 -> String 타입의 Json
            /**
             * 내가 통신을 줄 때
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}