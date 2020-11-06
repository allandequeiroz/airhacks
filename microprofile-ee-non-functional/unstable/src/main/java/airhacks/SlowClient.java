package airhacks;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.metrics.annotation.SimplyTimed;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("hello")
@RegisterRestClient(configKey = "slow")
public interface SlowClient {
    
    
    @Retry
    @SimplyTimed
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    Response message();
}
