package com.avb.curd.config;

import com.avb.curd.entity.User;
import com.avb.curd.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserInfo implements UserDetailsService {

    @Autowired
    UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userInfo = userRepo.findByName(username);
        return userInfo.map(com.avb.curd.config.UserDetailsService::new)
                .orElseThrow(()->new UsernameNotFoundException("User Details not found for the given name" +username));
    }
}
