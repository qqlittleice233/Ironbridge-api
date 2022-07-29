package com.qqlittleice.ironbridge.api.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import androidx.annotation.Keep;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Keep
@Retention(RUNTIME)
@Target({METHOD, FIELD})
public @interface BridgeVersion {
    int value();
}
