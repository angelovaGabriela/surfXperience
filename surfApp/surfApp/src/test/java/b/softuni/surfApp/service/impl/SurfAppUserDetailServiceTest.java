package b.softuni.surfApp.service.impl;

import b.softuni.surfApp.repository.TestUserRepository;
import b.softuni.surfApp.user.SurfAppUserDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class SurfAppUserDetailServiceTest {

    public static final String TEST_USER_NAME = "testUser";


    private SurfAppUserDetailsService toTest;

    @BeforeEach
    public void setUp() {
        toTest = new SurfAppUserDetailsService(new TestUserRepository());
    }

    @Test
    public void loadUserByUsername_UserFound() {
      UserDetails userDetails = toTest.loadUserByUsername(TEST_USER_NAME);

        Assertions.assertInstanceOf(SurfAppUserDetails.class, userDetails);

        SurfAppUserDetails surfAppUserDetails = (SurfAppUserDetails) userDetails;

        Assertions.assertEquals(TEST_USER_NAME, userDetails.getUsername());
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

}
