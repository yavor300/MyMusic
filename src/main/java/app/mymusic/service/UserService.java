package app.mymusic.service;

import app.mymusic.domain.models.service.UserServiceModel;

public interface UserService {
    UserServiceModel register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    UserServiceModel findById(String id);
}
