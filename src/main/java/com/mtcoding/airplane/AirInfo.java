package com.mtcoding.airplane;

import com.mtcoding.ex10.Hello;
import com.solapi.shadow.retrofit2.http.Body;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//사이트 첫번째 목록 항공운항정보 목록 조회
@Data
public class AirInfo {
    private Response response;

    @Setter
    @Getter
    public static class Response {
        private Header header;
        private Body body;

        @Setter
        @Getter
        public static class Header {
            private String resultCode;
            private String resultMsg;
        }

        @Setter
        @Getter
        public static class Body {
            private Items items;
            private Integer numOfRows;
            private Integer pageNo;
            private Integer totalCount;

            @Setter
            @Getter
            public static class Items { //컬렉션 []_컬렉션 윗 파트에서 list 적용,
                // 즉 Items{} > item[], Itmes에서 컬렉션 적용
                private List<Item> item;

                @Setter
                @Getter
                public static class Item {
                    private String airlineNm;
                    private String arrAirportNm;
                    private String arrPlandTime;
                    private String depAirportNm;
                    private String depPlandTime;
                    private Integer economyCharge;
                    private Integer prestigeCharge;
                    private String vihicleId;

                }
            }
        }
    }

}
