package com.desper.resources;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.desper.controller.ActionController;
import com.desper.controller.ActionTypeController;
import com.desper.dao.ActionDao;
import com.desper.dto.ActionDto;
import com.desper.dto.ActionTypeDto;
import io.dropwizard.hibernate.UnitOfWork;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;


@Path("/actions")
@Produces(APPLICATION_JSON)
public class ActionTypeResource {

    private final ActionTypeController actionTypeController;
    private final ActionController actionController;
    private final ActionDao actionDao;

    @Inject
    public ActionTypeResource(ActionTypeController actionTypeController, ActionController actionController, ActionDao actionDao) {
        this.actionTypeController = actionTypeController;
        this.actionController = actionController;
        this.actionDao = actionDao;
    }

    @GET
    @Timed
    @ExceptionMetered
    @UnitOfWork(readOnly = true, transactional = false)
    @Path("/types")
    public List<ActionTypeDto> getActionsTypes() {

        return actionTypeController.getAllActionTypes().orElseThrow(() -> new NotFoundException("No such action types."));
    }

    @POST
    @Consumes(APPLICATION_JSON)
    @UnitOfWork(readOnly = false, transactional = true)
    public ActionDto createAction(ActionDto actionDto){
        return actionController.create(actionDto);
    }

    @GET
    @Timed
    @ExceptionMetered
    @UnitOfWork(readOnly = true, transactional = false)
    @Path("{id}")
    public ActionDto getActionsById(@NotNull @PathParam("id")Long id) {
        ActionDto actionDto = null;
        try{
            actionDto = actionController.findById(id);
        } catch (Exception e){
            throw new NotFoundException("Not found Action Element");
        }
        return actionDto;
    }

    @DELETE
    @Path("{id}")
    @UnitOfWork(readOnly = false, transactional = true)
    public Response deleteAction(@NotNull @PathParam("id")Long id){
        ActionDto actionDto = new ActionDto();
        actionDto.setId(id);
        actionController.delete(actionDto);
        return Response.ok().build();
    }
}
