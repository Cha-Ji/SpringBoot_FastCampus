package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
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

    @Test
    public void registerUser(){
        String email = "tester@example.com";
        String name = "Tester";
        String password = "test";
        userService.registerUser(email, name, password);

        verify(userRepository).save(any());

    }

}