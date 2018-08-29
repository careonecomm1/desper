package com.desper.controller;

import com.desper.core.Action;
import com.desper.dao.ActionDao;
import com.desper.dto.ActionDto;
import com.desper.mapper.ActionMapper;
import com.desper.service.ActionService;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

import static org.slf4j.LoggerFactory.getLogger;

public class ActionController extends BaseController<ActionDto, Action>{

    private final Logger logger = getLogger(getClass());
    private final ActionMapper actionMapper;
    private final ActionDao actionDao;
    private final ActionService actionService;

   @Inject
    public ActionController(ActionMapper mapper, ActionDao actionDao, ActionService actionService){
        super(actionDao,mapper);
        this.actionMapper = mapper;
        this.actionDao = actionDao;
        this.actionService = actionService;
    }

    public Optional<List<ActionDto>> getActionsBySequence(Long sequenceId){
        List<ActionDto> actionStream = actionService.getActionsBySequence(sequenceId);

        return Optional.of(actionStream);
    }

    public ActionDto create(ActionDto actionDto){
       Action action = new Action();
       action.setName(actionDto.getName());
       action.setActionTypeId(actionDto.getActionTypeId());
       action.setAssociatedElement(actionDto.getAssociatedElement());
       return actionMapper.createApiDto(actionDao.create(action));
    }

    public void delete(ActionDto actionDto){
       Action action = new Action();
       action.setId(actionDto.getId());
       actionDao.delete(action);
    }
}
