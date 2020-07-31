package com.ielusc.apisaude.models;

import com.ielusc.apisaude.helpers.GeneralStatus;
import com.ielusc.apisaude.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> userModel = userRepository.findByUserNameAndStatus(username, GeneralStatus.ACTIVE);
        if (userModel.isPresent()){
            return new User(userModel.get().getUserName(), userModel.get().getPassword(), Collections.emptyList());
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}
