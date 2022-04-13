package com.example.data.mapper;

import com.example.data.dto.TeamDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DataMapper {
    // 팀 불러오기
    List<TeamDTO> roadTeam(int teamId) throws Exception;
}
