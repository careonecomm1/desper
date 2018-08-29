package com.desper.service;

import com.desper.core.ActionType;
import com.desper.dao.ActionTypeDao;
import com.desper.dto.ActionTypeDto;
import com.desper.mapper.ActionTypeMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

public class ActionTypeService {

    private final ActionTypeDao actionTypeDao;
    private final ActionTypeMapper actionTypeMapper;

    @Inject
    public ActionTypeService(ActionTypeDao actionTypeDao, ActionTypeMapper actionTypeMapper) {
        this.actionTypeDao = actionTypeDao;
        this.actionTypeMapper = actionTypeMapper;
    }

    public List<ActionTypeDto> getActionTypes() {
        Optional<List<ActionType>> allActionTypes = actionTypeDao.findAllActionTypes();

        List<ActionTypeDto> actionTypeDtoList = new ArrayList<>();

        allActionTypes
                .get()
                .stream()
                .forEach( att -> {
                    ActionTypeDto actionTypeDto = actionTypeMapper.createApiDto(att);
                    actionTypeDtoList.add(actionTypeDto);
                });

        return actionTypeDtoList;
    }
}
