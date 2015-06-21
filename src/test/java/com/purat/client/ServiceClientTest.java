package com.purat.client;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ServiceClientTest {

    @InjectMocks
    ServiceClient<BeanWithAnnotations> serviceClient;
    @Test
    public void testClient() {
    serviceClient.connect(createBeanWithAnnotations());
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