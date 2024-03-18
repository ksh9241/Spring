package com.example.userservice.vo;

import lombok.Data;
import lombok.NonNull;

@Data
public class RequestLogin {

    @NonNull
    private String email;

    @NonNull
    private String password;

}
