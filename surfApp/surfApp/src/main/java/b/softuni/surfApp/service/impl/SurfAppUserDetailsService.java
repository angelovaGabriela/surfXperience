package b.softuni.surfApp.service.impl;

import b.softuni.surfApp.model.entity.UserEntity;
import b.softuni.surfApp.model.entity.UserRoleEntity;
import b.softuni.surfApp.model.enums.UserRoleEnum;
import b.softuni.surfApp.repository.UserRepository;
import b.softuni.surfApp.user.SurfAppUserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

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
        return new SurfAppUserDetails(
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getRoles().stream().map(UserRoleEntity::getRole).map(SurfAppUserDetailsService::map).toList(),
                userEntity.getFirstName(),
                userEntity.getLastName()
        );
    }

    private static GrantedAuthority map(UserRoleEnum role) {
        return new SimpleGrantedAuthority(
                "ROLE_" + role
        );
    }

}
