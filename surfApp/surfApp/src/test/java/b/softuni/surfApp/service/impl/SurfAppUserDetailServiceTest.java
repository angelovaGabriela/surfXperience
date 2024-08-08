package b.softuni.surfApp.service.impl;

import b.softuni.surfApp.model.entity.UserEntity;
import b.softuni.surfApp.model.entity.UserRoleEntity;
import b.softuni.surfApp.model.enums.UserRoleEnum;
import b.softuni.surfApp.repository.UserRepository;
import b.softuni.surfApp.user.SurfAppUserDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class SurfAppUserDetailServiceTest {

    private static final String TEST_USERNAME = "testUser";
    private static final String TEST_FAKE_USERNAME = "pug";


    private SurfAppUserDetailsService toTest;
    @Mock
    private  UserRepository mockUserRepository;

    @BeforeEach
    public void setUp() {
         toTest = new SurfAppUserDetailsService(mockUserRepository);
    }

    @Test
    public void loadUserByUsername_UserFound() {

        UserEntity testUser = new  UserEntity()
                .setUsername(TEST_USERNAME)
                .setPassword("puggcandia")
                .setFirstName("Gabriela")
                .setLastName("Angelova")
                .setRoles(List.of(
                        new UserRoleEntity().setRole(UserRoleEnum.ADMIN),
                        new UserRoleEntity().setRole(UserRoleEnum.USER)
                ));

        when(mockUserRepository.findByUsername(TEST_USERNAME))
                .thenReturn(Optional.of(testUser));

        UserDetails userDetails = toTest.loadUserByUsername(TEST_USERNAME);

        Assertions.assertInstanceOf(SurfAppUserDetails.class, userDetails);

        SurfAppUserDetails surfAppUserDetails = (SurfAppUserDetails) userDetails;

        Assertions.assertEquals(TEST_USERNAME, userDetails.getUsername());
        Assertions.assertEquals(testUser.getPassword(), userDetails.getPassword());
        Assertions.assertEquals(testUser.getFirstName(), surfAppUserDetails.getFirstName());
        Assertions.assertEquals(testUser.getLastName(), surfAppUserDetails.getLastName());
        Assertions.assertEquals(testUser.getFullName(), surfAppUserDetails.getFullName());


        var expectedRoles = testUser.getRoles().stream().map(UserRoleEntity::getRole).map(r-> "ROLE_" + r).toList();
        var actualRoles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        Assertions.assertEquals(expectedRoles, actualRoles);
//
//        Optional<? extends GrantedAuthority> admin = userDetails.getAuthorities().stream().filter(a -> "ROLE_ADMIN".equals(a.getAuthority())).findAny();
//        Assertions.assertTrue(admin.isPresent());
//
//        Optional<? extends GrantedAuthority> user = userDetails.getAuthorities().stream().filter(a -> "ROLE_USER".equals(a.getAuthority())).findAny();
//        Assertions.assertTrue(user.isPresent());

    }

    @Test
    public void loadUserByUsername_UserNotFound() {

        Assertions.assertThrows(UsernameNotFoundException.class, ()
                -> toTest.loadUserByUsername(TEST_FAKE_USERNAME));
    }

}
