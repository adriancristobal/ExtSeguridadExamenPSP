package jakarta.rest;


import dao.RatonDAO;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.log4j.Log4j2;
import model.Informe;
import model.Raton;

import java.util.List;

@Path("ratones/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Log4j2
@RolesAllowed("raton")
public class RestRaton {

    @Context
    private HttpServletRequest request;
    private final RatonDAO dao;

    @Inject
    public RestRaton(RatonDAO dao) {
        this.dao = dao;
    }


    @GET
    public List<Raton> getRatones() {
        return dao.getRatones();
    }

    @POST
    @RolesAllowed("biologo")
    public Response addRaton(Raton raton) {
        dao.addRaton(raton);
        return Response.status(Response.Status.CREATED).entity(raton).build();
    }


}
