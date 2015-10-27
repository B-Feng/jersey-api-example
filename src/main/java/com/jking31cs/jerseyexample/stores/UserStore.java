package com.jking31cs.jerseyexample.stores;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.jking31cs.jerseyexample.objects.User;

import java.util.List;

/**
 * This is where we do all the saving user info to/from the datastore using Objectify.
 */
public class UserStore {

    private final Objectify objectify;

    public UserStore(Objectify objectify) {
        this.objectify = objectify;
    }

    public List<User> getAll() {
        return objectify.load().type(User.class).list();
    }

    public User get(Long uid) {
        return objectify.load().type(User.class).id(uid).now();
    }

    public User save(User user) {

        Key<User> key = objectify.save().entity(user).now();
        return objectify.load().key(key).now();
    }

    public User delete(User user) {

        objectify.delete().entity(user).now();
        return user;
    }

}




