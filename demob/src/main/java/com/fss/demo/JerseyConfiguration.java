package com.fss.demo;

import io.cloudevents.http.restful.ws.CloudEventsProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.fss.demo.controller.DemoBController;


@Configuration
public class JerseyConfiguration extends ResourceConfig {

    public JerseyConfiguration() {
        // Configure Jersey to load the CloudEventsProvider (which serializes/deserializes CloudEvents)
        // and our resource
        registerClasses(CloudEventsProvider.class, DemoBController.class);
    }

}
