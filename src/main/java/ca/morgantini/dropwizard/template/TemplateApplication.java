package ca.morgantini.dropwizard.template;

import ca.morgantini.dropwizard.template.resources.AdminResource;
import ca.morgantini.dropwizard.template.resources.HelloWorldResource;
import com.sun.jersey.spi.container.servlet.ServletContainer;
import io.dropwizard.Application;
import io.dropwizard.jersey.DropwizardResourceConfig;
import io.dropwizard.jersey.setup.JerseyContainerHolder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TemplateApplication extends Application<ServiceConfiguration> {


    public static void main(String[] args) throws Exception {
        new TemplateApplication().run(args);
    }


    @Override
    public void run(ServiceConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(new HelloWorldResource());

        final DropwizardResourceConfig jerseyConfig = new DropwizardResourceConfig(environment.metrics());
        JerseyContainerHolder jerseyContainerHolder = new JerseyContainerHolder(new ServletContainer(jerseyConfig));

        jerseyConfig.getSingletons().add(new AdminResource());

        environment.admin().addServlet("admin resources", jerseyContainerHolder.getContainer()).addMapping("/admin/*");
    }

    @Override
    public void initialize(Bootstrap<ServiceConfiguration> bootstrap) {
    }
}
