package org.car.service;

import org.car.entity.User;
import org.car.entity.UserDto;
import org.car.mapper.UserMapper;
import org.car.repository.UserRepository;
import org.car.util.PasswordUtil;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService extends AbstractService<User, UserDto, Integer> {
    private final UserRepository repository;

    public UserService(final UserRepository repository) {
        super(new UserMapper(), repository);
        this.repository = repository;
    }

    @Override
    public User create(final UserDto dto) {
        dto.setPassword(PasswordUtil.encode(dto.getPassword()));
        return super.create(dto);
    }

    @Override
    public User update(final UserDto dto,
                       final Integer id) {
        final Optional<User> user = repository.findById(id);
        if (passwordCompare(user.get().getPassword(), dto.getPassword())) {
            return super.update(dto, id);
        }
        dto.setPassword(PasswordUtil.encode(dto.getPassword()));
        return super.update(dto, id);
    }

    public UserDto findByUsername(final String userName) {
        final User user = repository.findUserByUserName(userName);
        return mapper.toDto(user);
    }

    public UserDto findByEmail(final String email) {
        final User user = repository.findUserByEmail(email);
        return mapper.toDto(user);
    }

    private boolean passwordCompare(final String password, final String ePassword) {
        return PasswordUtil.compare(password, ePassword);
    }
}
