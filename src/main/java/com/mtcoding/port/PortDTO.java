package com.mtcoding.port;

/**
 * 주소 : https://apis.data.go.kr/1613000/DmstcFlightNvgInfoService/getArprtList?serviceKey=d36e07c26abc33f8702aa40645d0eb399b2ab126b2405394bbe45e2572b2a050&_type=json
 */

//공항정보
//DTO -> Data Transfer object 데이터 전송 오브젝트

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PortDTO {

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
    }

    // items
    @Getter
    @Setter
    public static class Items {
        private List<Item> item;
    }

    // item (공항 정보)
    @Getter
    @Setter
    public static class Item {
        private String airportId;
        private String airportNm;
    }
}