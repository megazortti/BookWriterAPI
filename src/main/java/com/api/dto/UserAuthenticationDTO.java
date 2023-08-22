package com.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAuthenticationDTO {
    private String mail;
    private String password;
    public UserAuthenticationDTO(String mail, String password){
        this.mail = mail;
        this.password=password;
    }
}
