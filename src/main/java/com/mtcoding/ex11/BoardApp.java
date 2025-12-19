package com.mtcoding.ex11;


import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
class Common {
    private Integer status;
    private String msg;

    private List<Body> body;

    @Getter
    @Setter
    public static class Body {
        private Integer id;
        private String title;
        private String content;
        private String author;
    }

}

public class BoardApp {
    public static void main(String[] args) {
        try {
            // 1. 다운로드 -소켓연결
            String json = Repository.download("http://192.168.0.99:8080/api/boards");

            // 2. 다운로드 확인
            System.out.println("정상적으로 다운로드 됐습니다");

            // 3. 오브젝트로 변환
            Gson gson = new Gson();
            Common b = gson.fromJson(json, Common.class);
            //4. 변환 확인
            System.out.println("변환 확인이 정상작동했습니다");
            //5. 출력
            System.out.println(b.getStatus());
            System.out.println(b.getMsg());


            //6. body는 for문으로 적용!

            // list = [body, body, body, body, ... body]
            List<Common.Body> list = b.getBody();
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getId());
                System.out.println(list.get(i).getTitle());
                System.out.println(list.get(i).getContent());
                System.out.println(list.get(i).getAuthor());

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
