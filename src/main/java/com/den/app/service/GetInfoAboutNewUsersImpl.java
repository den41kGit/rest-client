package com.den.app.service;

import com.den.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.*;

/**
 * Класс отвечающий за полуения инфо о новых юзерах через RestTemplate
 */
@Component
@EnableScheduling
public class GetInfoAboutNewUsersImpl implements GetInfoService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${urlForUsers}")
    private String urlForUsers;

    private final List<User> users = new ArrayList<>();

    @Override
    @Scheduled(fixedRate = 120_000)
    public void getInfo() {
        ResponseEntity<ArrayList<User>> userResponse = restTemplate.exchange(
                urlForUsers, HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<User>>(){}
        );
        ArrayList<User> list = userResponse.getBody();

        if (list != null){
            for(User u : list){
                if(!(users.contains(u))){
                    System.out.println("Новый пользователь: " + u);
                    users.add(u);
                }
            }
        }
    }
}

