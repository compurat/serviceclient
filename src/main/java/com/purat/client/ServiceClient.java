package com.purat.client;

import com.purat.ServiceConnector;
import com.purat.client.annotation.ConnectionName;
import com.purat.client.annotation.FieldName;
import com.purat.constants.FieldNames;
import org.apache.http.entity.mime.content.AbstractContentBody;
import org.apache.http.entity.mime.content.StringBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by compurat on 21-6-15.
 */
@Component
public class ServiceClient<T> {

    @Autowired
    private ServiceConnector serviceConnector;

    public String connect(String url, Map<String, AbstractContentBody> parts) {
        return serviceConnector.getServiceResponse(url, parts);
    }

}
