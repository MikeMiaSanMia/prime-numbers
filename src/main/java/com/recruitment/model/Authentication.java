package com.recruitment.model;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;

public class Authentication implements ClientRequestFilter {

    private final String login;
    private final String password;

    public Authentication(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public void filter(ClientRequestContext clientRequestContext) {
        MultivaluedMap<String, Object> headers = clientRequestContext.getHeaders();
        final String basicAuthentication = getBasicAuthentication();
        headers.add("Authorization", basicAuthentication);
    }

    private String getBasicAuthentication() {
        String token = this.login + ":" + this.password;
        try {
            return "Basic " + DatatypeConverter.printBase64Binary(token.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ueExp) {
            throw new IllegalStateException("Problem with encoding UTF-8", ueExp);
        }
    }
}
