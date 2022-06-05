package org.stadium.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.stadium.dto.CodeDto;
import org.stadium.dto.UserDto;
import org.stadium.entity.User;
import org.stadium.mapper.UserMapper;
import org.stadium.repository.UserRepository;
import org.stadium.util.PasswordUtil;

import java.util.Optional;


@Service
public class UserService extends AbstractService<User, UserDto, Integer> {
    private final UserRepository repository;

    @Autowired
    private CodeService codeService;

    public UserService(final UserRepository repository) {
        super(new UserMapper(), repository);
        this.repository = repository;
    }

    public UserDto getLoggedInUser() {
        return loggedInUser();
    }

    @Override
    public User create(final UserDto dto) {
        dto.setPassword(PasswordUtil.encode(dto.getPassword()));
        return super.create(dto);
    }

    public boolean changePassword(final String oldPassword,
                               final String newPassword) {
        final UserDto user = getLoggedInUser();
        if (PasswordUtil.compare(oldPassword, user.getPassword())) {
            user.setPassword(newPassword);
            update(user, user.getId());
            return true;
        } else {
            return false;
        }
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

    public Boolean verifyAccount(final String email,
                                 final Integer code) {
        final UserDto user = this.findByEmail(email);
        if (user == null) {
            throw new IllegalStateException("This email doesn't found.");
        }
        final CodeDto scheduler = codeService.findCodeBy(email);
        if (scheduler != null && scheduler.getValue().equals(code)) {
            user.setVerified(true);
            this.update(user, user.getId());
            codeService.deleteByCode(code);
            return true;
        }
        return false;
    }

    private boolean passwordCompare(final String password, final String ePassword) {
        return PasswordUtil.compare(password, ePassword);
    }

    private UserDto loggedInUser() {
        final Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = null;
        if (obj instanceof UserDetails) {
            username = ((UserDetails) obj).getUsername();
        }
        return mapper.toDto(repository.findUserByUserName(username));
    }
}
