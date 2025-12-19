package com.mtcoding.port;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;


public class PortApp {
    public static void main(String[] args) {
        /**
         * 초보때는 try 로 잡기
         */

        try{
            //1. 공항정보 다운로드 (완료)
            PortRepository repo = new PortRepository(); //객체생성
            String portJson = repo.download("https://apis.data.go.kr/1613000/DmstcFlightNvgInfoService/getArprtList?serviceKey=d36e07c26abc33f8702aa40645d0eb399b2ab126b2405394bbe45e2572b2a050&_type=json");
            //다운로드는 문자열 json을 리턴한다.
            System.out.println(1);
            //문자열을 볼때 "보기>Json"에서 보면 좋음
            //NAARKJB를 사용자가 알 수 없음 " 무안" 이라는 것을 넣으면 쓸 수 있게 HashMap에 다이렉트로 쓸 수 있게 하는 것


            //2. PortDTO에 파싱(Gson 필요)
            Gson gson = new Gson();
            //PortDTO에 Gson을 옮기는 것이 목표
            PortDTO port= gson.fromJson(portJson, PortDTO.class);
            // fromJson : JSON 문자열 -> 자바 객체로 변환하는 메서드, 주로 Gson 라이브러리에서 사용
            //공항 목록 조회가 가능합니다.
            System.out.println(2);


            //3. HashMap에 옮기기(완)
            List<PortDTO.Item> list = port.getResponse().getBody().getItems().getItem(); //List의 아이템
            // list는 item을 의미 size = 15
            HashMap<String, String> map = new HashMap<>();// <String, String> = 키와 벨류 값 모두 문자열이다.
            //매번 .. 해서 쓰기 힘드니 hashmap 사용
            //map.put("무안","NAARKJB");
            //map.put("광주","NAARKJJ");

            for(PortDTO.Item item : list){
                String key = item.getAirportNm();//무안
                String value = item.getAirportId();
                map.put(key, value);
            }
            System.out.println(3);


            System.out.println(map.get("광주"));

            //4. 출발지(김해), 목적지(김포), 출발시간(20251220) 키보드로 입력받기
            //값을 고정으로 넣고 테스트 반복
            //기분데이터 사용
            String dep ="김해";
            String arr ="김포";
            String time ="20251220";



            //5. 해시맵에서 김해 -> key, 김포 -> value (완)
            String depId = map.get(dep);
            String arrId = map.get(arr);
            System.out.println(5);


            //6. 항공스케줄 동적주소 만들기(완)
            //해당방법을 통해 replace를 사용하지 않고 주소내용 수정 가능
            String site = "https://apis.data.go.kr/1613000/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=d36e07c26abc33f8702aa40645d0eb399b2ab126b2405394bbe45e2572b2a050&pageNo=1&numOfRows=10&_type=json&depAirportId="+depId+"&arrAirportId="+arrId+"&depPlandTime="+time;
            System.out.println(6);


            //7. 항공스케줄 다운로드(완)
            String scheduleJson = repo.download(site);
            System.out.println(7);


            //8. ScheduleDTO에 파싱(자바 오브젝트로 변환)(완)
            ScheduleDTO schedule = gson.fromJson(scheduleJson, ScheduleDTO.class);
            //(파싱하고 싶은 제이슨, 요 클래스)
            System.out.println(8);

            //9. 항공 스케줄 출력
            List<ScheduleDTO.Item> list2 = schedule.getResponse().getBody().getItems().getItem();
            for(ScheduleDTO.Item item : list2){

                if(item.getEconomyCharge() == null){
                    //else 안쓰고 필터링
                    System.out.println("항공권이 없습니다");
                    // 깔끔하게 continue
                    System.out.println();
                    continue;
                }

                System.out.println("출발지 : "+item.getDepAirportNm());
                System.out.println("도착지 : "+item.getArrAirportNm());
                System.out.println("출발시간 : "+item.getDepPlandTime());
                System.out.println("도착시간 : "+item.getArrPlandTime());
                //삼항연산자 (ternary operator) null이면 0을 넣고 아니라면 금액넣어줘!
                System.out.println("이코노미가격 : "+item.getEconomyCharge());//null 값이 있을 수 있어 터질수도있음 그래서 if 사용
                System.out.println();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
