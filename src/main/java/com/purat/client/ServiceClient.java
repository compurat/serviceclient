package com.purat.client;

import com.purat.ServiceConnector;
import com.purat.client.annotation.ConnectionName;
import com.purat.client.annotation.FieldName;
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

    private static final String CONNECTION = "connection";
    @Autowired
    private ServiceConnector serviceConnector;

    public String connect(String url, Map<String, AbstractContentBody> parts) {
        return serviceConnector.getServiceResponse(url, parts);
    }




    public Map<String, AbstractContentBody> createParts(T bean) {

        Map<String, AbstractContentBody> parts = new HashMap<String, AbstractContentBody>();
        ConnectionName connectionName = bean.getClass().getDeclaredAnnotation(ConnectionName.class);
        try {
            parts.put(CONNECTION, new StringBody(String.valueOf(connectionName.connectionName())));
            Field[] fields = bean.getClass().getDeclaredFields();
            for(Field field : fields) {
                field.setAccessible(true);
                FieldName fieldName = field.getAnnotation(FieldName.class);
                String name  = null;
                if (fieldName != null) {
                    name = fieldName.fieldName();
                } else {
                    name = field.getName();
                }
                    StringBody stringBody = new StringBody(String.valueOf(field.get(bean)));
                    parts.put(name,stringBody);
                field.setAccessible(false);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return parts;
    }


}
