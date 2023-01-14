package dev.smithereens.security.mapper;

import dev.smithereens.security.dto.TokenRequest;
import dev.smithereens.security.dto.UserDto;
import dev.smithereens.security.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "role", constant = "USER")
    User toEntity(UserDto userDTO);

    UserDto toDto(User user);

    @Mapping(target = "role", constant = "USER")
    User fromTokenRequestToUser(TokenRequest tokenRequest);
}
