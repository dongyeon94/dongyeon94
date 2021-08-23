package com.project.egloo.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/social")
public class SocialMember {

    @GetMapping("/naverlogin")
    public String naverLogin(){
//        OAuth2AccessToken oauthToken = naverLoginBO.getAccessToken(session, code, state);
        System.out.println("====================== start ==============================");

        System.out.println("======================  end  ==============================");
        return "200";
    }

//    @GetMapping("/naverlogin")
//    public String naverLogin(){
//        System.out.println("====================================================");
////        System.out.println("code : "+ code);
////        System.out.println("state : " + state);
//        System.out.println("====================================================");
//        HashMap<String, Object> naverUserInfo = new HashMap<>();
//        String reqURL = "https://openapi.naver.com/v1/nid/me";
//        try {
//            URL url = new URL(reqURL);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("POST"); //요청에 필요한 Header에 포함될 내용
//            conn.setRequestProperty("Authorization", "Bearer " + "AAAAOtyotwil1P5yS9PYR3pFXofyrwEYV-_2nwqxUcLQ5GbMe-RuP03LwVqxEYA1-mzoBHT1KdJ4_OnUYWODVJ3wVpc");
//            int responseCode = conn.getResponseCode();
//            if(responseCode == 200){
//                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                String line = "";
//                String result = "";
//                while ((line = br.readLine()) != null) {
//                    result += line;
//                }
//                System.out.println("sdss");
//                System.out.println(result);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//        }
//
//        return "200";
//    }

    @GetMapping("/naversign")
    public String naverSignup(@RequestParam String code, @RequestParam String state){
        System.out.println("====================================================");
        System.out.println("code : "+ code);
        System.out.println("state : " + state);
        System.out.println("====================================================");
        HashMap<String, Object> naverUserInfo = new HashMap<>();
        String reqURL = "https://openapi.naver.com/v1/nid/me";
        try {
            URL url = new URL(reqURL);
            String accessToken = "AAAAOtyotwil1P5yS9PYR3pFXofyrwEYV-_2nwqxUcLQ5GbMe-RuP03LwVqxEYA1-mzoBHT1KdJ4_OnUYWODVJ3wVpc";
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST"); //요청에 필요한 Header에 포함될 내용
            conn.setRequestProperty("Authorization", "Bearer " + accessToken);
            int responseCode = conn.getResponseCode();
            if(responseCode == 200){
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = "";
                String result = "";
                while ((line = br.readLine()) != null) {
                    result += line;
                }
                System.out.println("sdfsdfsdf");
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return "200";
    }
}
