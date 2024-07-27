package b.softuni.surfApp.service.impl;

import b.softuni.surfApp.model.entity.UserEntity;
import b.softuni.surfApp.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

//TODO: https://www.baeldung.com/role-and-privilege-for-spring-security-registration#custom-userdetailsservice

public class SurfAppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public SurfAppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return userRepository.
                findByUsername(username).
                map(SurfAppUserDetailsService::map).
                orElseThrow(() -> new UsernameNotFoundException("User " + username + " is not found!"));
    }

    private static UserDetails map(UserEntity userEntity) {
        return User.withUsername(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(List.of())
                .disabled(false) /*TODO*/
                .build();
    }

//    private GrantedAuthority map(UserRoleEntity userRole) {
//        return new SimpleGrantedAuthority("ROLE_" +
//                userRole.getName());
//    }
}
