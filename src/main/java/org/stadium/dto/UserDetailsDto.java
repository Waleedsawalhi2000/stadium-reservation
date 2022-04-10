package org.stadium.dto;


import org.stadium.entity.User;
import org.stadium.repository.UserRepository;
import org.stadium.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;



public class UserDetailsDto implements UserDetails {
    private final String username;
    private final String password;
    private final boolean active;
    private final List<GrantedAuthority> authorities;
    private final UserService userService;

    public UserDetailsDto(final UserRepository userRepository, final String username) {
        final User user = userRepository.findUserByUserName(username);
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.active = user.isActive();
        this.authorities = Arrays.stream(user.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        this.userService = new UserService(userRepository);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        final UserDto user = getCurrentUser();
        if (user == null) {
            throw new UsernameNotFoundException("This user isn't found");
        }
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        final UserDto user = getCurrentUser();
        if (user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    public UserDto getCurrentUser() {
        return userService.findByUsername(username);
    }
}
