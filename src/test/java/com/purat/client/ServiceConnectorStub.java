package com.purat.client;

import com.purat.ServiceConnector;
import org.apache.http.entity.mime.content.AbstractContentBody;

import java.util.Map;

/**
 * Created by compurat on 22-6-15.
 */
public class ServiceConnectorStub {

    private static final String HELLO_WORLD = "Hello world";

    public static String getServiceResponse() {
        return HELLO_WORLD;
    }
}
