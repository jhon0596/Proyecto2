package ServerMeditec;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/medi")
public class Medi {
@GET
      public String getMessage() {
            return "Hello World";
      }
}