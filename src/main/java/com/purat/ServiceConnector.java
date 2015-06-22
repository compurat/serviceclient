package com.purat;

import org.apache.http.entity.mime.content.AbstractContentBody;

import java.util.Map;

/**
 * Created by compurat on 22-6-15.
 */
public interface ServiceConnector {
    String getServiceResponse(String url, Map<String, AbstractContentBody> parts);
}
