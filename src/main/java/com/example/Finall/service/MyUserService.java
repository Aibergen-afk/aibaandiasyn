package com.example.Finall.service;

import com.example.Finall.model.Permission;
import com.example.Finall.model.User;
import com.example.Finall.repository.PermissionRepository;
import com.example.Finall.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PermissionRepository permissionRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(User user) {
        Permission roleUser = permissionRepository
                .findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("ROLE_USER not found"));

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getPermissions().add(roleUser);

        userRepository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        return userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found: " + username));
    }
}
