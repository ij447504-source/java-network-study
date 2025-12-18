package com.mtcoding.ex10;

import com.solapi.shadow.retrofit2.Response;
import com.solapi.shadow.retrofit2.http.Body;
import com.solapi.shadow.retrofit2.http.Header;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.PrintWriter;
import java.util.List;

@Data
public class Hello {
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
            private String dataType;
            private Items items;
            private Integer pageNo;//값이 들어오지 않을 때 null 추출 가능
            private Integer numOfRows;
            private Integer totalCount;

            @Setter
            @Getter
            public static class Items { //컬렉션 []
                private List<Item> item; //Item이 아닌 List로 들어가야함 제네릭

                @Setter
                @Getter
                public static class Item {
                    private String baseDate;
                    private String baseTime;
                    private String category;
                    private int nx;
                    private int ny;
                    private String obsrValue;
                }
            }
        }
    }

}
