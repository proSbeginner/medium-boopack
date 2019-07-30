package com.pros.boopack.user;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Length(max = 100)
    @NotEmpty
    private String email;

    @Length(max = 100)
    @NotEmpty
    private String password;

    @Length(max = 100)
    private String firstName;

    @Length(max = 100)
    private String lastName;

    private boolean isEnabled;

    private Date emailRegisteredDate;

    private Date createdDate;

    private Date modifiedDate;

    public User() {
        this.createdDate = new Date();
        this.modifiedDate = new Date();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public Date getEmailRegisteredDate() {
        return emailRegisteredDate;
    }

    public void setEmailRegisteredDate(Date emailRegisteredDate) {
        this.emailRegisteredDate = emailRegisteredDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
