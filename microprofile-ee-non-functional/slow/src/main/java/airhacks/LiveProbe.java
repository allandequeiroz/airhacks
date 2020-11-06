package airhacks;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@ApplicationScoped
@Liveness
public class LiveProbe implements HealthCheck{

	@Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.up("basic");
    }
    
}
