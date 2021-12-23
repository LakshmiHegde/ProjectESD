package com.example.projectesd.controller;

import com.example.projectesd.Service.BillService;
import com.example.projectesd.Service.StudentService;
import com.example.projectesd.bean.BillDetails;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

@Path("bill")
public class BillDetailsController {

    @GET
    @Path("/display")
    @Produces(MediaType.APPLICATION_JSON) //return type

    public Response read() throws URISyntaxException {
        List<BillDetails> b= new BillService().read(); //in service
        return Response.ok().entity(b).build();
    }
}
