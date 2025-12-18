package com.mtcoding.airplane;



import com.google.gson.Gson;
import com.mtcoding.ex10.Hello;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AirApp {

    //key = 무안, value = NAARKJB
    static Map<String, String> ports = new HashMap();

    public static void main(String[] args) {

        try {
            //1. 공항정보를 다운 - HttpUrlConnection으로!! //3번째 다운소스 김해는 NAARKPK이다.
            String site = "https://apis.data.go.kr/1613000/DmstcFlightNvgInfoService/getArprtList?serviceKey=d36e07c26abc33f8702aa40645d0eb399b2ab126b2405394bbe45e2572b2a050&_type=json";


            URL url = new URL(site);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            Scanner sc = new Scanner(conn.getInputStream());
            String json = "";
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                json = json + line;
            }
//            System.out.println(json);

            //2. PortInfo로 오브젝트화 시켜!!

            Gson gson = new Gson();
            PortInfo portInfo = gson.fromJson(json,PortInfo.class);



            //3. ports에 airportID에 있는 값, airportNm에 있는 값을 넣기
            // 나중에 해봐야지!!

            //4. 스캐너로 출발지를 받기
            String dep = "김해"; //무안
            String depkey = "NAARKPK";

            //5. 스캐너로 목적지 받기
            String arr = "김포"; //부산
            String arrkey = "NAARKSS";

            //6. 날짜받기
            String time = "20251219"; //20251219


            //7. 동적인 URL 만들기
            String site2 = """
                https://apis.data.go.kr/1613000/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=d36e07c26abc33f8702aa40645d0eb399b2ab126b2405394bbe45e2572b2a050&pageNo=1&numOfRows=24&_type=json&depAirportId=${depkey}&arrAirportId=${arrkey}&depPlandTime=${time}
                """.replace("${depkey}",depkey).replace("${arrkey}",arrkey).replace("${time}",time);

            //8. 항공스케줄 다운 = HttpUrlConnection 호출
            URL url2 = new URL(site2);
            HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
            conn2.setRequestMethod("GET");

            Scanner sc2 = new Scanner(conn2.getInputStream());
            String json2 = "";
            while(sc2.hasNextLine()){
                String line = sc2.nextLine();
                json2 = json2 + line;
            }


            //9. 파싱 -> AirInfo로 파싱, 첫번째 목록 항공운항정보 목록 조회 티웨이, 제주, 광주, vihicleId": "TW901.. 등등
            AirInfo airInfo = gson.fromJson(json2,AirInfo.class);
            List<AirInfo.Response.Body.Items.Item> itemList2 = airInfo.getResponse().getBody().getItems().getItem();
            String name = itemList2.get(1).getAirlineNm();


            //10. 항공 스케줄 예쁘게 전체 출력
            for (AirInfo.Response.Body.Items.Item item : itemList2){
                System.out.println(item.getAirlineNm());
                System.out.println(item.getArrAirportNm());
                System.out.println(item.getArrPlandTime());
                System.out.println(item.getDepAirportNm());
                System.out.println(item.getDepPlandTime());
                System.out.println(item.getEconomyCharge());
                System.out.println(item.getPrestigeCharge());
                System.out.println(item.getVihicleId());
                System.out.println();
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }





    }
}
