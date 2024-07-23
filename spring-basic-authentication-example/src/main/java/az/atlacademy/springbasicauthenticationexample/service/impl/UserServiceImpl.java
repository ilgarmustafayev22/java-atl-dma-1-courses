package az.atlacademy.springbasicauthenticationexample.service.impl;

import az.atlacademy.springbasicauthenticationexample.UserNotFoundException;
import az.atlacademy.springbasicauthenticationexample.dao.entity.UserEntity;
import az.atlacademy.springbasicauthenticationexample.dao.repository.UserRepository;
import az.atlacademy.springbasicauthenticationexample.model.enums.UserRole;
import az.atlacademy.springbasicauthenticationexample.model.request.UserRequest;
import az.atlacademy.springbasicauthenticationexample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder encoder;
    private final UserRepository userRepository;


    @Override
    public void createUser(UserRequest request) {
        UserEntity userEntity = UserEntity
                .builder()
                .name(request.getName())
                .surname(request.getSurname())
                .username(request.getUsername())
                .password(encoder.encode(request.getPassword()))
                .age(request.getAge())
                .userRole(UserRole.USER)
                .build();
        userRepository.save(userEntity);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("user not found with username + " + username));
    }

}
