package com.mtcoding.ex11;

import com.google.gson.Gson;

import java.awt.image.DataBufferDouble;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
//다운로드를 간단하게 가보자(3단계 ->1단계)
public class PostNetworkApp {
    public static void main(String[] args) {
        try{
            Repository repo = new Repository();
            String json = repo.download("https://jsonplaceholder.typicode.com/posts/1");
            //리턴해줌


            Gson gson = new Gson();
            Post p = gson.fromJson(json, Post.class);
            System.out.println(1);
        } catch (Exception e) { //무조건 트라이를 하지말고 !  초보때는 부모의 오류까지 잡아내는 것이 나음
            e.printStackTrace();//라인과 오류를 정확하게 찾아냄
        }

    }
}
