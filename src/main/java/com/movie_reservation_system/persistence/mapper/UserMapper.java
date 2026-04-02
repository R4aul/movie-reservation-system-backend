package com.movie_reservation_system.persistence.mapper;

import com.movie_reservation_system.domain.dto.User;
import com.movie_reservation_system.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toDTO(UserEntity entity);
}
