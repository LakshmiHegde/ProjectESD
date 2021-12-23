package com.example.projectesd.controller;

import com.example.projectesd.Service.BillService;
import com.example.projectesd.Service.StudentService;
import com.example.projectesd.bean.BillDetails;
import com.example.projectesd.bean.Student;
import com.example.projectesd.bean.UpdateClass;
import net.bytebuddy.asm.Advice;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

@Path("student")
public class StudentController {
    @POST
    @Path("/update")
    @Produces(MediaType.TEXT_PLAIN) //return type
    @Consumes(MediaType.APPLICATION_JSON) //parameter
    public Response update(UpdateClass s) throws URISyntaxException {

        System.out.println("Entered");
        boolean val = new StudentService().update(s); //in service
        System.out.println("val = "+val);
        if (val == true)
            return Response.ok().build();
        else
            return Response.status(203).build();

    }

    @GET
    @Path("/display")
    @Produces(MediaType.APPLICATION_JSON) //return type

    public Response read() throws URISyntaxException {
        List<BillDetails> b= new BillService().read(); //in service
        return Response.ok().entity(b).build();
    }
}
