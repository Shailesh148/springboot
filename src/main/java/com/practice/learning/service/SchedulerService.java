package com.practice.learning.service;


import com.practice.learning.model.FetchPlanogram;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SchedulerService {

    private RestTemplate restTemplate;

//    private DataFetchRepository dataFetchRepository;

    SchedulerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
//        this.dataFetchRepository = dataFetchRepository;
    }

//    @Scheduled(fixedRate = 15000)
    public void getCurrentTime() {
        System.out.println("currentTime:" + new Date().toString());
        List<FetchPlanogram> allAislesList = new ArrayList<>();
        //        List<FetchPlanogram> allAislesList = dataFetchRepository.fetchAisles("1144");
        System.out.println("size of all list: " + allAislesList.size());
        System.out.println(restTemplate.getForObject("http://localhost:8080/start_check", String.class));
    }
}
