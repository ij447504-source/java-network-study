package com.mtcoding.airplane;
//두번째 목록 공항 목록조회

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Data
public class PortInfo {
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

            @Setter
            @Getter
            public static class Items { //컬렉션 []
                private List<Item> item;

                @Setter
                @Getter
                public static class Item {
                    private String airportId;
                    private String airportNm;


                }
            }
        }
    }
}