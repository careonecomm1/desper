package com.desper.service;

import com.desper.core.Action;
import com.desper.dao.ActionDao;
import com.desper.dao.ActionDao;
import com.desper.dto.ActionDto;
import com.desper.dto.ActionDto;
import com.desper.mapper.ActionMapper;
import com.desper.mapper.ActionMapper;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ActionService {

    private final ActionDao actionDao;
    private final ActionMapper actionMapper;

    @Inject
    public ActionService(ActionDao actionDao, ActionMapper actionMapper) {
        this.actionDao = actionDao;
        this.actionMapper = actionMapper;
    }

    public List<ActionDto> getActionsBySequence(Long sequenceId) {
        Optional<List<Action>> allActions = actionDao.findActionsBySequence(sequenceId);

        List<ActionDto> actionDtoList = new ArrayList<>();

        allActions.get().stream().forEach( act -> {
                    ActionDto actionDto = actionMapper.createApiDto(act);
                    actionDtoList.add(actionDto);
                });

        return actionDtoList;
    }
}
