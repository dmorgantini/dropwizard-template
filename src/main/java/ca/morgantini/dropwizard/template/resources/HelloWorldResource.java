package ca.morgantini.dropwizard.template.resources;


import ca.morgantini.dropwizard.template.services.HelloWorldService;
import com.google.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello-world")
public class HelloWorldResource {

    private final HelloWorldService helloWorldService;

    @Inject
    public HelloWorldResource(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GET
    public String sayHelloWorld(){
//        return helloWorldService.sayHello();
        throw new RuntimeException(helloWorldService.toString());
    }

}
