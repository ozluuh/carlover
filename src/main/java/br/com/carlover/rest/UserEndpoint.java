package br.com.carlover.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.carlover.connection.ConnectionFactory;
import br.com.carlover.dao.UserDao;
import br.com.carlover.dao.impl.UserDaoImpl;
import br.com.carlover.exception.CommitTransactionException;
import br.com.carlover.model.User;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserEndpoint {

    private UserDao dao = new UserDaoImpl(ConnectionFactory.getConnection());

    @GET
    public List<User> index() {
        return dao.findAll();
    }

    @GET
    @Path("{id}")
    public Response show(@PathParam("id") Long id) {
        User entity = dao.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.status(Response.Status.OK).entity(entity).build();
    }

    @POST
    public Response store(User entity) {
        dao.save(entity);
        try {
            dao.commit();
        } catch (CommitTransactionException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.status(Response.Status.ACCEPTED).entity(entity).build();
    }
}
