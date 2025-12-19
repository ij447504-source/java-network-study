package com.mtcoding.ex11;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Post {//같은 패키지 내 public 없이 사용가능
    //필드4개
    //상태 4개 : Interger
    private Integer userId; //Interger : 0이 들어와도 null 안전하게 추출
    private Integer id;
    private String title;
    private String body;
    //gson으로 내용을 채울 예정



}
//Gson 라이브러리 작동 방법
//1. Post 객체를 new -> 디폴트 생성자를 new 한다
//2. Post 객체의 setter를 호출한다.
public class PostApp {
    public static void main(String[] args) {
        String json = """
                {
                "userId": 1,
                "id": 1,
                "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                "body": "quia et suscipit suscipit recusandae consequuntur expedita et cum reprehenderit molestiae ut ut quas totam nostrum rerum est autem sunt rem eveniet architecto"
                }
                """;

        Gson gson = new Gson(); //두번째 인수에 타입을 넣어줘야함
        Post p = gson.fromJson(json, Post.class);
        //p에 담긴 것을 확인
        System.out.println(1);

    }
}
