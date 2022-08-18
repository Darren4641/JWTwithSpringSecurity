package com.Service;

import com.ErrorHandler.AuthenticationCustomException;
import com.ErrorHandler.ErrorCode;
import com.Model.Users;
import com.Repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Optional<Users> user = usersRepository.findById(id);

        if(user.isPresent()) {
            return user.get();
        }
        throw new AuthenticationCustomException(ErrorCode.UsernameOrPasswordNotFoundException);
    }

}
