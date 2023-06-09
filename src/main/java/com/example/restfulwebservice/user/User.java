package com.example.restfulwebservice.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class User {
    private Integer id;

    @Size(min = 2 , message = "Name은 2글자 이상 입력해주세요. ")
    private String name;
    @Past
    private Date joinDate;

    public User() {
    }
}
