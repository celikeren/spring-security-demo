package dev.smithereens.security.dto;

import lombok.Data;

@Data
public class UserDto {

    private String displayName;

    private String username;

    private String password;
}
