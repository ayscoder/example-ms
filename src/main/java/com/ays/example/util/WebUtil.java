package com.ays.example.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author ayush agrahari created on 07/03/2021
 */
public final class WebUtil {
    private WebUtil() {
    }

    public static <D> ResponseEntity<WebResponse<D>> toResponseEntity(WebResponse<D> webResponse) {
        HttpStatus httpStatus = webResponse.getHttpStatusCode();
        webResponse.setHttpStatusCode(null);
        return new ResponseEntity<>(webResponse, httpStatus);
    }
}

