package com.desper.controller;

import com.desper.core.ActionType;
import com.desper.dao.ActionTypeDao;
import com.desper.dto.ActionTypeDto;
import com.desper.mapper.ActionTypeMapper;
import com.desper.service.ActionTypeService;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

import static org.slf4j.LoggerFactory.getLogger;

public class ActionTypeController extends BaseController<ActionTypeDto, ActionType>{

    private final Logger logger = getLogger(getClass());
    private final ActionTypeMapper actionTypeMapper;
    private final ActionTypeDao actionTypeDao;
    private final ActionTypeService actionTypeService;

   @Inject
    public ActionTypeController(ActionTypeMapper mapper, ActionTypeDao actionTypeDao, ActionTypeService actionTypeService){
        super(actionTypeDao,mapper);
        this.actionTypeMapper = mapper;
        this.actionTypeDao = actionTypeDao;
        this.actionTypeService = actionTypeService;
    }

    public Optional<List<ActionTypeDto>> getAllActionTypes(){
        List<ActionTypeDto> actionTypesStream = actionTypeService.getActionTypes();

        return Optional.of(actionTypesStream);
    }
}
