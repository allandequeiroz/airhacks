package airhacks;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.metrics.annotation.Counted;

@Path("/hello")
public class HelloResource {

    Logger LOG = Logger.getLogger(HelloResource.class.getName());

    @GET
    @Counted
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        LOG.info("called");
        return "hello";
    }
}