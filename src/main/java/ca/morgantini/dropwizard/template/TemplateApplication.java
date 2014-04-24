package ca.morgantini.dropwizard.template;

import ca.morgantini.dropwizard.template.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TemplateApplication extends Application<ServiceConfiguration> {


    public static void main(String[] args) throws Exception {
        new TemplateApplication().run(args);
    }


    @Override
    public void run(ServiceConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(new HelloWorldResource());
    }

    @Override
    public void initialize(Bootstrap<ServiceConfiguration> bootstrap) {
    }
}
