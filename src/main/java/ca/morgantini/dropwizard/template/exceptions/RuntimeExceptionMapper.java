package ca.morgantini.dropwizard.template.exceptions;

import ca.morgantini.dropwizard.template.services.HelloWorldService;
import com.google.inject.Inject;
import com.google.inject.Provider;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException>{


    private final Provider<ServletRequest> context;
    @Inject
    private Provider<HelloWorldService> helloWorldService;

    @Inject
    public RuntimeExceptionMapper(Provider<ServletRequest> context) {
        this.context = context;
    }

    @Override
    public Response toResponse(RuntimeException exception) {
        HttpServletRequest httpContext = (HttpServletRequest) context.get();
        return Response.status(400).entity(httpContext.getHeader("Content-Type") + " - " + helloWorldService.get().toString() + " : " + exception.getMessage()).build();

    }
}
