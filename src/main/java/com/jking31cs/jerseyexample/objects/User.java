
package com.jking31cs.jerseyexample.objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.util.Objects;

/**
 * This object holds the data for a user.
 */
@Entity
public class User {

    @Id
    private Long uid;

    private String uname;

    private String uemail;

    @JsonCreator
    public User(
            @JsonProperty("uid") Long uid,
            @JsonProperty("uname") String uname,
            @JsonProperty("uemail") String uemail
    ) {
        this.uid = uid;
        this.uname = uname;
        this.uemail = uemail;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid() {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname() {
        this.uname = uname;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail() {
        this.uemail = uemail;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(uid, user.uid) &&
                Objects.equals(uname, user.uname) &&
                Objects.equals(uemail, user.uemail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid,uname,uemail);
    }

}
