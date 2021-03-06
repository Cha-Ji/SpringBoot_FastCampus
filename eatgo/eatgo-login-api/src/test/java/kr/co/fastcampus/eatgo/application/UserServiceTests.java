package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.User;
import kr.co.fastcampus.eatgo.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class UserServiceTests {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Before //널포인터익셉션
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        userService = new UserService(userRepository, passwordEncoder); //의존성 설정
    }



    @Test
    public void authenticateWithValidAttributes(){
        String email = "tester@example.com";
        String password = "test";


        User mockUser = User.builder()
                .email(email)
                .build();

        given(userRepository.findByEmail(email))
                .willReturn(Optional.of(mockUser));

        given(passwordEncoder.matches(any(), any())).willReturn(true);
        User user = userService.authenticate(email, password);

        assertThat(user.getEmail(), is(email));
    }

    @Test(expected = EmailNotExistedException.class)
    public void authenticateWithNotExistedEmail(){
        String email = "x@example.com";
        String password = "test";

        given(userRepository.findByEmail(email))
                .willReturn(Optional.empty());

        userService.authenticate(email, password);

    }

    @Test(expected = PasswordWrongException.class)
    public void authenticateWithWrongPassword(){
        String email = "tester@example.com";
        String password = "x";

        User mockUser = User.builder().email(email).build();

        given(userRepository.findByEmail(email))
                .willReturn(Optional.of(mockUser));

        given(passwordEncoder.matches(any(), any())).willReturn(false);


        userService.authenticate(email, password);

    }
}