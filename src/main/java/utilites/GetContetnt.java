package main.java.utilites;

import main.java.entity.Page;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/{param}")
public class GetContetnt {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Page getPageinJSON(@PathParam("param") String id) {
        Integer id_int = Integer.parseInt(id);

        Page page = PageDAO.getPageByID(id_int);

        return page;

    }

}
