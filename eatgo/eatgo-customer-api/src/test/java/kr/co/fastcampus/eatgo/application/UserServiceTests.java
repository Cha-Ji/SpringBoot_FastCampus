package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.User;
import kr.co.fastcampus.eatgo.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class UserServiceTests {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Before //널포인터익셉션
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        userService = new UserService(userRepository); //의존성 설정
    }

    @Test(expected= EmailExistedException.class)
    public void registerUserWithExistedEmail(){

        //이미 있는 유저에 대해 어떻게 대처해야 하는가?
        String email = "tester@example.com";
        String name = "Tester";
        String password = "test";

        User user = User.builder().build();
        given(userRepository.findByEmail(email)).willReturn(Optional.of(user));

        userService.registerUser(email, name, password);

//        verify(userRepository, never()).save(any());

    }

}