import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;


@javax.ws.rs.ApplicationPath("resources")
@Path("/hello")
public class Hello extends javax.ws.rs.core.Application {

    @Context
    private UriInfo context;

    @GET
    @Produces("application/xml")
    public String getXml() {
        return "<xml>Hello world</xml>";
    }

    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
