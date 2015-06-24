package com.purat.client;

import com.purat.MultipartBuilder;
import com.purat.ServiceConnector;
import com.purat.ServiceConnectorImpl;
import org.apache.http.entity.mime.content.AbstractContentBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by compurat on 21-6-15.
 */

public class ServiceClient<T> {




    public String connect(String url, T bean) {
        ServiceConnector serviceConnector = new ServiceConnectorImpl();
        MultipartBuilder<T> multipartBuilder = new MultipartBuilder<T>();
        Map<String, AbstractContentBody> parts = multipartBuilder.createParts(bean);
        return serviceConnector.getServiceResponse(url, parts);
    }

}
