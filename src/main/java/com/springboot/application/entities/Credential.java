package com.springboot.application.entities;

import lombok.Data;

@Data
public class Credential {
    private String mail;
    private String password;


    public Credential() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Credential(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }



}

