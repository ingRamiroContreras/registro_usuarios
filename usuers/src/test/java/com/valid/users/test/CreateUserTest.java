package com.valid.users.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.valid.users.applicationservice.CreateUserWithProcessFalse;
import com.valid.users.applicationservice.UserListBd;
import com.valid.users.domain.User;
import com.valid.users.domain.UserDto;
import com.valid.users.infraestructure.UsersRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CreateUserTest {

    @Mock
    private UsersRepository repository;

    @InjectMocks
    private CreateUserWithProcessFalse createUserService;

    @InjectMocks
    private UserListBd userListBd;

    @Before
    public void setUp() {

        when(repository.saveAndFlush(any()))
        .thenAnswer(e -> {
            User user = (User) e.getArguments()[0];
            return user;
        });

        User juan = new User(UUID.randomUUID().toString(),"Juan","Cuadrado",Boolean.FALSE);
        User james = new User(UUID.randomUUID().toString(),"James","Rodriguez",Boolean.FALSE);
        User falcao = new User(UUID.randomUUID().toString(),"Falcao","Garcia",Boolean.TRUE);


        when(repository.findAll()).thenReturn(Arrays.asList(juan,james,falcao));

    }

    @Test
    public void createUser() {

        UserDto userCreate = createUserService
                .createUser(new UserDto(null, "Andres", "Escobar", Boolean.TRUE));

        assertNotNull(userCreate.getId());
    }

    @Test
    public void getAllUsers(){
        List<UserDto> users = userListBd.getUserList();

        assertTrue(users.size() > 0);
    }

}
