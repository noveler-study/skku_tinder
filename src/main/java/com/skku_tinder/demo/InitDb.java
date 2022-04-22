package com.skku_tinder.demo;

import com.skku_tinder.demo.domain.User;
import com.skku_tinder.demo.domain.UserRole;
import com.skku_tinder.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.usertype.UserType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.dbInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{

        private final UserRepository userRepository;
        public void dbInit(){
            User user = new User("dldudtls@naver.com", "123", "dldudtls2@naver.com", UserRole.USER);
            userRepository.save(user);
        }
    }
}
