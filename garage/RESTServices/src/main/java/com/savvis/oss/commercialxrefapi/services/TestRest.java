package com.savvis.oss.commercialxrefapi.services;



import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestRest {

    public static void main(String[] args) {
        try {

            Client client = Client.create();

            WebResource webResource = client
                    .resource("http://localhost:8080/restservices/rest/rest-srs/getecho?getecho=me");


            ClientResponse response = webResource.accept("text/plain")
                    .get(ClientResponse.class);


            if (response.getStatus() != 200) {
                //throw new RuntimeException("Failed : HTTP error code : "                            + response.getStatus());
                System.out.println("Response code is " + response.getStatus());
            }

            String output = response.getEntity(String.class);

            System.out.println("Output from Server .... \n");
            System.out.println(output);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
