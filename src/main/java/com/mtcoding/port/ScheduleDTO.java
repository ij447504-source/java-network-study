package com.mtcoding.port;

/**
 * 1. 항공운항정보 목록조회
 * https://apis.data.go.kr/1613000/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=d36e07c26abc33f8702aa40645d0eb399b2ab126b2405394bbe45e2572b2a050&pageNo=1&numOfRows=10&_type=json&depAirportId=NAARKJJ&arrAirportId=NAARKPC&depPlandTime=20251220
 */


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ScheduleDTO {

    private Response response;

    // response
    @Getter
    @Setter
    public static class Response {
        private Header header;
        private Body body;
    }

    // header
    @Getter
    @Setter
    public static class Header {
        private String resultCode;
        private String resultMsg;
    }

    // body
    @Getter
    @Setter
    public static class Body {
        private Items items;
        private int numOfRows;
        private int pageNo;
        private int totalCount;
    }

    // items
    @Getter
    @Setter
    public static class Items {
        private List<Item> item;
    }

    // item (항공편 정보)
    @Getter
    @Setter
    public static class Item {
        private String airlineNm;
        private String arrAirportNm;
        private long arrPlandTime; //인수값 범윌 인해 long 사용
        private String depAirportNm;
        private long depPlandTime;

        private Integer economyCharge;   // 없는 경우 null 가능
        private Integer prestigeCharge;  // 없는 경우 null 가능

        private String vihicleId;
    }
}

