package com.movie_reservation_system.persistence;

import com.movie_reservation_system.domain.dto.RegisterRequest;
import com.movie_reservation_system.domain.dto.User;
import com.movie_reservation_system.domain.exception.AlreadyExistsException;
import com.movie_reservation_system.domain.exception.NotFoundException;
import com.movie_reservation_system.domain.repository.RegisterUserRepository;
import com.movie_reservation_system.domain.repository.RoleListCrudRepository;
import com.movie_reservation_system.domain.repository.UserRepository;
import com.movie_reservation_system.persistence.entity.RoleEntity;
import com.movie_reservation_system.persistence.entity.UserEntity;
import com.movie_reservation_system.persistence.mapper.UserMapper;
import com.movie_reservation_system.persistence.repository.UserListCrudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserEntityRepository implements UserRepository , RegisterUserRepository {

    private final UserListCrudRepository repository;
    private final RoleListCrudRepository roleListCrudRepository;
    private final UserMapper mapper;

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return this.repository.findByEmail(email);
    }

    @Override
    public User register(RegisterRequest request) {
        if (this.repository.findByEmail(request.getEmail()).isPresent()){
            throw new AlreadyExistsException("User Already Exists");
        }
        RoleEntity roleEntity = roleListCrudRepository.findByName("CUSTOMER")
                .orElseThrow(() -> new NotFoundException("Role Not Found"));

        UserEntity user = UserEntity.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(roleEntity)
                .build();
        return this.mapper.toDTO(this.repository.save(user));
    }
}
