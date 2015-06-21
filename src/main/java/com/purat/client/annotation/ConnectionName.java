package com.purat.client.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by compurat on 21-6-15.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ConnectionName {
    String connectionName();

}
