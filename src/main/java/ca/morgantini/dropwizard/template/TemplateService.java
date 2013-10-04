package ca.morgantini.dropwizard.template;

import ca.morgantini.dropwizard.template.exceptions.RuntimeExceptionMapper;
import ca.morgantini.dropwizard.template.guice.GuiceBundle;
import ca.morgantini.dropwizard.template.resources.HelloWorldResource;
import com.google.inject.servlet.GuiceFilter;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class TemplateService extends Service<ServiceConfiguration> {


    public static void main(String[] args) throws Exception {
        new TemplateService().run(args);
    }

    @Override
    public void initialize(Bootstrap<ServiceConfiguration> bootstrap) {
        bootstrap.addBundle(new GuiceBundle());
    }

    @Override
    public void run(ServiceConfiguration configuration, Environment environment) throws Exception {
        environment.addResource(RuntimeExceptionMapper.class);
        environment.addFilter(GuiceFilter.class, "/*");
        environment.addResource(HelloWorldResource.class);
    }
}
