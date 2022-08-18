package com.ErrorHandler;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class ApiResponse {
    private int code = HttpStatus.OK.value();
    private Object result;

    public ApiResponse() { }

    public void setResult(Object result) {
        this.result = result;
    }

    public static class ResponseMap extends ApiResponse {

        private Map responseData = new HashMap();

        public ResponseMap() {
            setResult(responseData);
        }

        public void setResponseData(String key, Object value) {
            this.responseData.put(key, value);
        }

    }
}
