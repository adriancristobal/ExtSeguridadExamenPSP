package jakarta.rest;

import jakarta.annotation.security.DeclareRoles;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api/")
@DeclareRoles({"raton", "curioso", "biologo", "informe", "nivel1", "nivel2", "espia"})
public class JAXRSApplication extends Application {
}