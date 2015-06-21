package com.purat.client;

import com.purat.client.annotation.ConnectionName;
import com.purat.client.annotation.FieldName;
import org.apache.http.entity.mime.content.AbstractContentBody;
import org.apache.http.entity.mime.content.StringBody;
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

    public void connect(T bean) {
        Map<String, AbstractContentBody> parts = createParts(bean);
    }

    private Map<String, AbstractContentBody> createParts(T bean) {
        Map<String, AbstractContentBody> parts = new HashMap<String, AbstractContentBody>();
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
            try {
                StringBody stringBody = new StringBody(String.valueOf(field.get(bean)));
                parts.put(name,stringBody);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            field.setAccessible(false);
        }

        return parts;
    }


}
