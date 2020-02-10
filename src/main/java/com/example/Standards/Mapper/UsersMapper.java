package com.example.Standards.Mapper;

import com.example.Standards.Model.Users;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsersMapper {

    UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);

    @Mappings({
            @Mapping(source = "uId", target = "id"),
            @Mapping(source = "uName", target = "name"),
            @Mapping(source = "uAddress", target = "address"),
            @Mapping(source = "uPhone", target = "phone"),
            @Mapping(source = "roles.role_name", target = "role")
    })
    UsersDTO usersToUsersDTO(Users entity);

    @InheritInverseConfiguration
    Users usersDTOToUsers(UsersDTO dto);
}
