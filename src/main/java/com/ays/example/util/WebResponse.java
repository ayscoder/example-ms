package com.ays.example.util;

import com.ays.example.common.enums.ApiMessage;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@JsonInclude(Include.NON_EMPTY)
@Getter
@Setter
public final class WebResponse<D> {
    private HttpStatus httpStatusCode;
    private String requestId;
    private String code;
    private String reason;
    private String message;
    private long count;
    private D data;

    public WebResponse(Builder<D> builder) {
        this.httpStatusCode = builder.httpStatusCode;
        this.requestId = builder.requestId;
        this.code = builder.code;
        this.reason = builder.reason;
        this.message = builder.message;
        this.data = builder.data;
        this.count = builder.count;
    }

    public static class Builder<D> {
        private final HttpStatus httpStatusCode;
        private final String requestId;
        private final String code;
        private final String reason;
        private final String message;
        private final long count;
        private D data;

        public Builder(HttpStatus httpStatusCode, String requestId, ApiMessage apiMessage, long count) {
            this.httpStatusCode = httpStatusCode;
            this.requestId = requestId;
            this.code = apiMessage.getCode();
            this.reason = apiMessage.getReason();
            this.message = apiMessage.getMessage();
            this.count = count;
        }

        public Builder<D> withData(D data) {
            this.data = data;
            return this;
        }

        public WebResponse<D> build() {
            return new WebResponse<>(this);
        }
    }
}
