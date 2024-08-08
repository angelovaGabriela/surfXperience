package b.softuni.surfApp.service.impl;

import b.softuni.surfApp.repository.TestUserRepository;
import b.softuni.surfApp.user.SurfAppUserDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class SurfAppUserDetailServiceTest {

    public static final String TEST_USERNAME = "testUser";
    public static final String TEST_FAKE_USERNAME = "pug";


    private SurfAppUserDetailsService toTest;

    @BeforeEach
    public void setUp() {
        toTest = new SurfAppUserDetailsService(new TestUserRepository());
    }

    @Test
    public void loadUserByUsername_UserFound() {
      UserDetails userDetails = toTest.loadUserByUsername(TEST_USERNAME);

        Assertions.assertInstanceOf(SurfAppUserDetails.class, userDetails);

        SurfAppUserDetails surfAppUserDetails = (SurfAppUserDetails) userDetails;

        Assertions.assertEquals(TEST_USERNAME, userDetails.getUsername());
        Assertions.assertEquals("puggcandia", userDetails.getPassword());
        Assertions.assertEquals("Gabriela", surfAppUserDetails.getFirstName());
        Assertions.assertEquals("Angelova", surfAppUserDetails.getLastName());
        Assertions.assertEquals("Gabriela Angelova", surfAppUserDetails.getFullName());

        Assertions.assertEquals(2, userDetails.getAuthorities().size());

        Optional<? extends GrantedAuthority> admin = userDetails.getAuthorities().stream().filter(a -> "ROLE_ADMIN".equals(a.getAuthority())).findAny();
        Assertions.assertTrue(admin.isPresent());

        Optional<? extends GrantedAuthority> user = userDetails.getAuthorities().stream().filter(a -> "ROLE_USER".equals(a.getAuthority())).findAny();
        Assertions.assertTrue(user.isPresent());

    }

    @Test
    public void loadUserByUsername_UserNotFound() {

        Assertions.assertThrows(UsernameNotFoundException.class, ()
                -> toTest.loadUserByUsername(TEST_FAKE_USERNAME));
    }

}
