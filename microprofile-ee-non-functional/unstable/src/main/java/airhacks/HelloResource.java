package airhacks;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.MetricRegistry.Type;
import org.eclipse.microprofile.metrics.annotation.RegistryType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/hello")
public class HelloResource {

    @Inject
    @RestClient
    SlowClient client;

    @Inject
    @RegistryType(type=Type.APPLICATION)
    MetricRegistry registry;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        var response = this.client.message();
        var status = response.getStatus();
        registry.counter("svc_slow_communication_status_" + status).inc();
        if (status != 200)
            return "don't understand your status";
        return "unstable calls slow and: " + response.readEntity(String.class);
    }
}