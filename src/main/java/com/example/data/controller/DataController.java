package com.example.data.controller;

import com.example.data.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/send/")
public class DataController {
    Message message;
//
//    @Autowired
//    private DataService dataService;

    @RequestMapping(value = "push")
    public Message getData(HttpServletRequest request) throws Exception{
        message = new Message();
        try{
            message.setMessage("정상적으로 값을 받았습니다.");
            String send_text1 = request.getParameter("send_text1");
            String send_text2 = request.getParameter("send_text2");
            System.out.println("정상적으로 값을 받았습니다.");
            System.out.println("첫 번째 데이터 : "+send_text1);
            System.out.println("두 번째 데이터 : "+send_text2);
            return message;
        }catch (Exception e){
            message.setMessage("서버에서 값을 받는 도중 문제가 발생했습니다.");
            System.out.println("서버에서 값을 받는 도중 문제가 발생했습니다.");
            e.printStackTrace();
            return message;
        }
    }

}

class Message{
    String message;

    Message(){}

    public Message(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}