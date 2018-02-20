package com.recruitment.model;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class ConnectDB {
    public String getServerContent() {
        final String URI = "http://dt-gwitczak-recruitment.westeurope.cloudapp.azure.com:8080/rest/task";
        final String LOGIN = "candidate";
        final String PASSWORD = "abc123";
        Client client = ClientBuilder.newClient().register(new Authentication(LOGIN, PASSWORD));
        WebTarget target = client.target(URI);
        Response response = target.request().get();
        return response.readEntity(String.class);
    }
}
