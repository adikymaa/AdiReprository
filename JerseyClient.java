package com.tutorialspoint;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
 
public class JerseyClient {
 
    public static void main(String[] args) {
        try {
 
            //Student st = new Student("Adriana", "Barrer", 12, 9);
            User user1 = new User(101,"Rajesh","sw engg");
 
            Client client = Client.create();
 
            WebResource webResource = client.resource("http://localhost:8080/MyRestfulWebService/rest/UserService/users");
 
            ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
 
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }
 
            String output = response.getEntity(String.class);
 
            System.out.println("Server response : \n");
            System.out.println(output);
 
        } catch (Exception e) {
 
            e.printStackTrace();
 
        }
 
    }
 
}