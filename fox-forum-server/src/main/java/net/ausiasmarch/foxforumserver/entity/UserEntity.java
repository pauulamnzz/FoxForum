package net.ausiasmarch.foxforumserver.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String lastname;
    private String email;
    private String username;
    @JsonProperty(access =JsonProperty.Access.WRITE_ONLY)//para que el pass no salga nunca del servidor
    private String password="e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e";
    private Boolean role;
    


    public UserEntity(){

    }



    public UserEntity(Long id, String name, String surname, String lastname, String email, String usename,
            String password, Boolean role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.email = email;
        this.username = usename;
        this.password = password;
        this.role = role;
    }

   public UserEntity(String name, String surname, String lastname, String email, String usename,
            String password, Boolean role) {
  
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.email = email;
        this.username = usename;
        this.password = password;
        this.role = role;
    }
       public UserEntity(String name, String password) {
  
        this.name = name;
       
        this.password = password;

    }



    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getSurname() {
        return surname;
    }



    public void setSurname(String surname) {
        this.surname = surname;
    }



    public String getLastname() {
        return lastname;
    }



    public void setLastname(String lastname) {
        this.lastname = lastname;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public String getUsename() {
        return username;
    }



    public void setUsename(String usename) {
        this.username = usename;
    }



    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }



    public Boolean getRole() {
        return role;
    }



    public void setRole(Boolean role) {
        this.role = role;
    }
    
}
