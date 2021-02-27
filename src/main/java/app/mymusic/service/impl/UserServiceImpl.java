package app.mymusic.service.impl;

import app.mymusic.domain.entities.User;
import app.mymusic.domain.models.service.UserServiceModel;
import app.mymusic.repository.UserRepository;
import app.mymusic.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserServiceModel register(UserServiceModel userServiceModel) {
        userRepository.save(
                modelMapper.map(userServiceModel, User.class)
        );
        return userServiceModel;
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository
                .findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public UserServiceModel findById(String id) {
        return modelMapper.map(userRepository.findById(id).get(), UserServiceModel.class);
    }
}
