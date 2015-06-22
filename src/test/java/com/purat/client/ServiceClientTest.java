package com.purat.client;


import com.purat.ServiceConnector;
import org.junit.Assert;
import org.apache.http.entity.mime.content.AbstractContentBody;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class ServiceClientTest {

    private static final String UPLOAD_URL = "http://localhost:8181/upload";
    private static final String HELLO_WORLD = "Hello world";

    @Mock
    ServiceConnector serviceConnector;
    @InjectMocks
    ServiceClient<BeanWithAnnotations> serviceClientWithAnnotations;
    @Test
    public void testCreatePartsWithAnnotations() {
        Map<String, AbstractContentBody> parts = serviceClientWithAnnotations.createParts(createBeanWithAnnotations());
        Assert.assertEquals(6,parts.size());

    }

    @Test
    public void testServiceConnect() {
        Map<String, AbstractContentBody> parts = serviceClientWithAnnotations.createParts(createBeanWithAnnotations());
        Mockito.when(serviceConnector.getServiceResponse(UPLOAD_URL,parts)).thenReturn(ServiceConnectorStub.getServiceResponse());
            String response = serviceClientWithAnnotations.connect(UPLOAD_URL, parts);
            Assert.assertTrue(HELLO_WORLD.equals(response));
    }

    private BeanWithAnnotations createBeanWithAnnotations() {
        BeanWithAnnotations beanWithAnnotations = new BeanWithAnnotations();
        beanWithAnnotations.setAddres("Prins HendrikStraat 28");
        beanWithAnnotations.setAge(50);
        beanWithAnnotations.setCity("Zaandam");
        beanWithAnnotations.setLastName("Roskam");
        beanWithAnnotations.setName("Pieter");
        return beanWithAnnotations;
    }
}