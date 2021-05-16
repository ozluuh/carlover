package br.com.carlover.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.carlover.connection.ConnectionFactory;
import br.com.carlover.dao.UserDao;
import br.com.carlover.dao.impl.UserDaoImpl;
import br.com.carlover.model.User;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserEndpoint {

    private UserDao dao = new UserDaoImpl(ConnectionFactory.getConnection());

    @GET
    public List<User> index() {
        return dao.findAll();
    }
}
