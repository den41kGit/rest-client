package com.den.app.service;

import com.den.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
@EnableScheduling
public class InfoCollectionServiceImpl implements InfoCollectionService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${url}")
    private String url;

    private final List<User> users = new ArrayList<>();

    @Override
    @Scheduled(fixedRate = 120_000)
    public void getInfo() {
        User[] list = restTemplate.getForObject(url, User[].class);

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

