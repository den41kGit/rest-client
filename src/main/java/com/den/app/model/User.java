package com.den.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String userName;
    private int password;
    private UserRole role;
}
