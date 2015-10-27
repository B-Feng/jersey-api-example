package com.jking31cs.jerseyexample.webservices;


import com.jking31cs.jerseyexample.objects.User;
import com.jking31cs.jerseyexample.stores.UserStore;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

 * This web service handles all the different http calls from a client to create, read, update, and delete User.
 * This is done using Jersey/JAX-RS (Java Application Rest Service API).
 */
@Path("api/users")
public class UserWebService {

    private final UserStore store;

    @Inject
    public UserWebService(UserStore store) {
        this.store = store;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return store.getAll();
    }

    @GET
    @Path("{uid}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("uid") Long uid) {
        return store.get(uid);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User saveNewUser(User user) {
        return store.save(user);
    }

    @PUT
    @Path("{uid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User updateUser(@PathParam("uid") Long uid, User user) {
        return store.save(user);
    }

    @DELETE
    @Path("{uid}")
    @Produces(MediaType.APPLICATION_JSON)
    public User deleteUser(@PathParam("uid") Long uid){
        return store.delete(store.get(uid));
    }

}


