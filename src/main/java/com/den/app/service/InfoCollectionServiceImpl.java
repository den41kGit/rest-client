package com.den.app.service;

import com.den.app.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
@EnableScheduling
public class InfoCollectionServiceImpl implements InfoCollectionService<User>{
    @Autowired
    private RestTemplate restTemplate;
    @Value("${url}")
    private String url;

    private static final List<User> users = new ArrayList<>();


    @Override
    @Scheduled(fixedRate = 60000)
    public List getInfo() {

        List users = restTemplate.getForObject(url, List.class);
        System.out.println("Все пользователи : " + users);
        return users;

    }

    @Override
    public void showChanges() {


    }
}
