package com.example.data.service;

import com.example.data.dto.TeamDTO;
import com.example.data.mapper.DataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataService {

    @Autowired
    DataMapper dataMapper;

    // 팀 정보 불러오기
    public List<TeamDTO> roadTeam() throws Exception{
        return dataMapper.roadTeam();
    }
}
