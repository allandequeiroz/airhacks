package airhacks;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class TooEarlyException extends WebApplicationException {
    
    public TooEarlyException(String message) {
        super(Response.status(205).header("info", message).build());
    }
    
}
