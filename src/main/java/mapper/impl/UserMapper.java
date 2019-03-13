package mapper.impl;

import dto.impl.UserDto;
import entity.User;
import mapper.Mapper;

public class UserMapper implements Mapper<UserDto, User> {
    @Override
    public User mapToObject(UserDto origin) {
        return new User();
    }

    @Override
    public UserDto mapToDto(User object) {

        return new UserDto();
    }
}
