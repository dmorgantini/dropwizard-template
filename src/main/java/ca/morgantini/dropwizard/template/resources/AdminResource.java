package ca.morgantini.dropwizard.template.resources;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello-world")
public class AdminResource {

    @GET
    public String sayHelloAdmin(){
        return "Hello Admin!";
    }

}
