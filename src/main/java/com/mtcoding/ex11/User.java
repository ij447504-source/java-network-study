package com.mtcoding.ex11;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
class User{ //3번 할 때 만들어야함
    private Integer id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private Company company; //Company 아무이름이나 하면 됨!

        @Setter
        @Getter
        static class Company { //내부클래스를 넣을 때는 static필요 그냥 외워!
            private String name;
            private String catchPhrase;
            private String bs;
        }
}

