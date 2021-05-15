package br.com.carlover.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.carlover.dao.CarDao;
import br.com.carlover.model.Car;

@Path("/cars")
public class CarEndpoint {

    CarDao dao = new CarDao();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> index() {
        return dao.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Car car) {
        if (car == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        try {
            dao.save(car);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.status(Response.Status.CREATED).entity(car).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response show(@PathParam("id") Long id) {
        Car car = dao.findById(id);
        if (car == null) {
            return Response.status(Response.Status.NOT_FOUND).entity(car).build();
        }
        return Response.status(Response.Status.OK).entity(car).build();
    }
}
