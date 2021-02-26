package com.valid.users.applicationservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.valid.users.domain.User;
import com.valid.users.infraestructure.UsersRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserProccesSaveBD implements UserProcess {

    private Logger logger = LoggerFactory.getLogger(UserProccesSaveBD.class);

    private UsersRepository repository;

    public UserProccesSaveBD(UsersRepository repository) {
        this.repository = repository;
    }

    @Override
    public void userProcess(String[] idUsers) {

        List<String> userToProcess = Arrays.asList(idUsers);

        List<User> usersDb = new ArrayList<>();

        for (String userId : userToProcess) {
            Optional<User> user = repository.findById(userId);
            if (user.isPresent()) {
                User userToSave = user.get();
                userToSave.setProcess(Boolean.TRUE);
                usersDb.add(userToSave);
            }else{
                logger.info("User id: {} is not valid", userId);
            }
        }

        repository.saveAll(usersDb);

    }

}
