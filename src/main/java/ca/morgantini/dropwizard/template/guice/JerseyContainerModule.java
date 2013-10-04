package ca.morgantini.dropwizard.template.guice;

import com.sun.jersey.guice.JerseyServletModule;

public class JerseyContainerModule extends JerseyServletModule {
    private final GuiceContainer container;
    /**
     * Creates a new JerseyModule.
     * <p/>
     * @param container a container binding Jersey to Guice
     */
    public JerseyContainerModule(GuiceContainer container)
    {
        this.container = container;
    }

    @Override
    protected void configureServlets()
    {
        bind(GuiceContainer.class).toInstance(container);
    }
}
