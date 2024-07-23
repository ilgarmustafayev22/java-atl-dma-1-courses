package az.atlacademy.springbasicauthenticationexample.service;

import az.atlacademy.springbasicauthenticationexample.dao.entity.UserEntity;
import az.atlacademy.springbasicauthenticationexample.model.request.UserRequest;

import java.util.Optional;

public interface UserService {

    void createUser(UserRequest request);

    UserEntity findByUsername(String username);

}
