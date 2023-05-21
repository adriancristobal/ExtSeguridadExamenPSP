package jakarta.rest;

import dao.InformeDAO;
import dao.RatonDAO;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import lombok.extern.log4j.Log4j2;
import model.Informe;
import model.Raton;

import java.util.List;

@Path("informes/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Log4j2
@RolesAllowed("informe")
public class RestInforme {

    @Context
    private HttpServletRequest request;
    private final InformeDAO dao;
    @Context
    private SecurityContext securityContext;

    @Inject
    public RestInforme(InformeDAO dao) {
        this.dao = dao;
    }

    @GET
    public List<Informe> getInformes() {
        String rol = null;
        if (securityContext.isUserInRole("nivel2")) {
            rol = "nivel2";
        } else {
            rol = "nivel1";
        }
        return dao.getInformes(rol);
    }

    @GET
    @Path("{id}")
    public Informe getInforme(@PathParam("id") int id) {
        String rol;
        if (securityContext.isUserInRole("nivel2")) {
            rol = "nivel2";
        } else {
            rol = "nivel1";
        }
        return dao.getInforme(id, rol);
    }

    @POST
    @RolesAllowed("espia")
    public Response addInforme(Informe informe) {
        dao.addInforme(informe);
        return Response.status(Response.Status.CREATED).entity(informe).build();
    }

}
