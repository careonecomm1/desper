package com.desper.mapper;

import com.desper.core.Action;
import com.desper.dto.ActionDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

public class ActionMapper implements Mapper<ActionDto, Action>{

    private static final Logger LOGGER = Logger.getLogger(ActionMapper.class);

    public ActionMapper() {}

    @Override
    public void updateEntity(Action entity, ActionDto dto) {}

    @Override
    public Action createEntity(Class<?> dtoClass) {
        return new Action();
    }

    @Override
    public ActionDto createApiDto(Action entity) {
        
        ObjectMapper mapper = new ObjectMapper();

        ActionDto actionDto = new ActionDto(
                entity.getId(),
                entity.getActionTypeId(),
                entity.getName(),
                entity.getDescription(),
                entity.getAssociatedElement());
        return actionDto;
    }


}

