package ca.morgantini.dropwizard.template.resources;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello-world")
public class HelloWorldResource {

    @GET
    public String sayHelloWorld(){
        return "Hello World!";
    }

}
