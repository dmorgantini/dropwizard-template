package ca.morgantini.dropwizard.template.guice;

import ca.morgantini.dropwizard.template.ServiceConfiguration;
import ca.morgantini.dropwizard.template.services.HelloWorldService;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.servlet.ServletScopes;
import com.yammer.dropwizard.ConfiguredBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class GuiceBundle implements ConfiguredBundle<ServiceConfiguration>{

    @Override
    public void run(ServiceConfiguration configuration, Environment environment) {
        GuiceContainer container = new GuiceContainer(environment.getJerseyResourceConfig());
        environment.setJerseyServletContainer(container);
        environment.addServletListeners();

        Guice.createInjector(new JerseyContainerModule(container), new AbstractModule() {
            @Override
            protected void configure() {
                bind(HelloWorldService.class).in(ServletScopes.REQUEST);
            }
        });
    }

    @Override
    public void initialize(Bootstrap<?> bootstrap) {
    }
}
