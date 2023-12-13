package b.softuni.surfApp.service;

import b.softuni.surfApp.model.entity.UserEntity;
import b.softuni.surfApp.model.entity.UserRoleEntity;
import b.softuni.surfApp.repository.UserRepository;
import b.softuni.surfApp.user.SurfAppUserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.stream.Collectors;

public class SurfAppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public SurfAppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }




    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return userRepository.
                findByEmail(username).
                map(this::map).
                orElseThrow(() -> new UsernameNotFoundException("User " + username + " is not found!"));
    }

    private UserDetails map(UserEntity userEntity) {
        return new SurfAppUserDetails(
                userEntity.getPassword(),
                userEntity.getEmail(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.
                        getUserRoles().
                        stream().
                        map(this::map).
                        collect(Collectors.toList()));
    }

    private GrantedAuthority map(UserRoleEntity userRole) {
        return new SimpleGrantedAuthority("ROLE_" +
                userRole.getUserRoleEnum().name());
    }
}
