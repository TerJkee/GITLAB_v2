package com.epam.metrics.connectors.rest;

import org.apache.http.Header;

/**
 * Created by ����� on 30.07.2017.
 */
public class RestException extends Exception {

    private int status;
    private String result;
    private Header[] headers;

    public RestException(String msg, int status, String result, Header[] headers) {
        super(msg);

        this.status = status;
        this.result = result;
        this.headers = headers;
    }

    public int getHttpStatusCode() {
        return status;
    }

    public String getHttpResult() {
        return result;
    }

    public Header[] getHeaders() {
        return headers;
    }

    public String getMessage() {
        return String.format("%s %s: %s", Integer.toString(status), super.getMessage(), result);
    }
}
