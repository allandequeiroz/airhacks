package airhacks;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.faulttolerance.Bulkhead;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.metrics.annotation.Counted;

@Path("/hello")
public class HelloResource {

    Logger LOG = Logger.getLogger(HelloResource.class.getName());

    @GET
    @Counted
    @Bulkhead(3)
    //@Fallback(fallbackMethod = "overload")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        LOG.info("called");
        //throw new TooEarlyException("good morning from ukraine");
        return "hello";
    }
    
    public String overload() {
        return "overloaded, don't call me";
    }
}