package com.example.projectesd.controller;

import com.example.projectesd.Service.BillService;
import com.example.projectesd.Service.CourseService;
import com.example.projectesd.bean.BillDetails;
import com.example.projectesd.bean.CourseFeeStr;
import com.example.projectesd.bean.UpdateCourse;
import com.example.projectesd.bean.UpdateDate;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

@Path("course")
public class CourseController {

    @POST
    @Path("/update")
    @Produces(MediaType.TEXT_PLAIN) //return type
    @Consumes(MediaType.APPLICATION_JSON) //parameter
    public Response update(UpdateCourse c) throws URISyntaxException {
        boolean val = new CourseService().update(c); //in service
        if (val == true)
            return Response.ok().build();
        else
            return Response.status(203).build();
    }

    @POST
    @Path("/updatedate")
    @Produces(MediaType.TEXT_PLAIN) //return type
    @Consumes(MediaType.APPLICATION_JSON) //parameter
    public Response updatedate(UpdateDate c) throws URISyntaxException {
        boolean val = new CourseService().updateDate(c); //in service
        if (val == true)
            return Response.ok().build();
        else
            return Response.status(203).build();
    }

    @GET
    @Path("/display")
    @Produces(MediaType.APPLICATION_JSON) //return type

    public Response read() throws URISyntaxException {
        List<CourseFeeStr> b= new CourseService().read(); //in service
        return Response.ok().entity(b).build();
    }

}
