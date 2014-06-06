package com.savvis.oss.commercialxrefapi.services;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Path("/rest-srs")
public class SampleRestServices {

        @GET
        @Path("/get")
        @Produces(MediaType.TEXT_XML)
        // public String addPlainText(@PathParam("a") double a, @PathParam("b") double b) {
        public String addPlainText() {

             String str = "aa";
            int ib = 0;
            int ia = 5;




           return "hello world really";
            

        }

    @GET
    @Path("/{echo}")
    @Produces(MediaType.TEXT_PLAIN)
    // public String addPlainText(@PathParam("a") double a, @PathParam("b") double b) {
    public String echoMe(@PathParam("echo")String echo) {

        String str = "aa";
        int ib = 0;
        int ia = 5;


        System.out.println("it's an error" + echo);
        return "hello world " + echo;


    }
}
