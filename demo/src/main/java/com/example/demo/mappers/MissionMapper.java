package com.example.demo.mappers;

import com.example.demo.domain.Mission;
import com.example.demo.dto.MissionDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MissionMapper {
    MissionDTO missionToMissionDTO(Mission source);
}