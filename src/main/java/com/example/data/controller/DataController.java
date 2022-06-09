package com.example.data.controller;

import com.example.data.dto.TeamDTO;
import com.example.data.service.DataService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/send/")
public class DataController {
    Message message;
    JSONArray jsonArray;

    @Autowired
    private DataService dataService;

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

    @RequestMapping(value = "get")
    public JSONArray roadText(HttpServletRequest request) throws Exception{
        jsonArray = new JSONArray();
        try{
            int teamId = Integer.parseInt(request.getParameter("team_id"));
            System.out.println("성공적으로 값을 받았습니다. teamId : "+teamId);
            List<TeamDTO> teamDTO = dataService.roadTeam(teamId);
            for(int i = 0; i < teamDTO.size(); i++){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("team_name",teamDTO.get(i).getTeamName());
                jsonObject.put("team_age",teamDTO.get(i).getTeamAge());
                jsonObject.put("team_email",teamDTO.get(i).getTeamEmail());
                jsonArray.add(jsonObject);
            }
            System.out.println(jsonArray);
            return jsonArray;
        }catch (Exception e){
            System.out.println("통신 실패");
            e.printStackTrace();
            return jsonArray;
        }
    }

    // 404 코드 호출
    @RequestMapping(value = "404")
    public ResponseEntity sendHttpCode404(HttpServletRequest request) throws Exception{
        try{
            String temp = request.getParameter("call_code");
            System.out.println("[Code : 404] 성공적으로 값을 받았습니다. temp : "+temp);
        }catch (Exception e){
            System.out.println("통신 실패");
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    // 403 코드 호출
    @RequestMapping(value = "403")
    public ResponseEntity sendHttpCode403(HttpServletRequest request) throws Exception{
        try{
            String temp = request.getParameter("call_code");
            System.out.println("[Code : 403] 성공적으로 값을 받았습니다. temp : "+temp);
        }catch (Exception e){
            System.out.println("통신 실패");
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    // 500 코드 호출
    @RequestMapping(value = "500")
    public ResponseEntity sendHttpCode500(HttpServletRequest request) throws Exception{
        try{
            String temp = request.getParameter("call_code");
            System.out.println("[Code : 500] 성공적으로 값을 받았습니다. temp : "+temp);
        }catch (Exception e){
            System.out.println("통신 실패");
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
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