package opensdm.web.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/getAllDevices")
public class GetAllDevices {

    @GET
    @Path("/{param}")
    public Response printMessage(@PathParam("param") String msg) {

        return Response.status(200).entity(msg).build();
    }

}
