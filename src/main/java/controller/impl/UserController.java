package controller.impl;

import controller.Controller;
import dto.impl.UserDto;
import entity.User;
import mapper.impl.UserMapper;
import service.Service;
import service.impl.UserService;

public class UserController implements Controller<UserDto> {
    private Service<User> userService;
    private UserMapper userMapper;

    public UserController() {
        userService = new UserService();
        userMapper = new UserMapper();
    }

    @Override
    public UserDto post(UserDto entity) {
        User user = userMapper.mapToObject(entity);
        userService.create(user);
        return userMapper.mapToDto(user);
    }

    @Override
    public UserDto get(UserDto entity) {
        User user = userMapper.mapToObject(entity);
        userService.get(user);
        return userMapper.mapToDto(user);
    }

    @Override
    public UserDto put(UserDto oldEntity, UserDto newEntity) {
        User user = userMapper.mapToObject(oldEntity);
        User user2 = userMapper.mapToObject(newEntity);
        userService.update(user, user2);
        return userMapper.mapToDto(user2);
    }

    @Override
    public void delete(UserDto entity) {
        User user = userMapper.mapToObject(entity);
        userService.delete(user);
    }
}
