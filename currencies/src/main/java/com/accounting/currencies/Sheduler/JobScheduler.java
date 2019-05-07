package com.accounting.currencies.Sheduler;

import com.accounting.currencies.Services.RateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.accounting.currencies.Services.DateService.today;

@Service
public class JobScheduler {

    @Autowired
    RateServices downloadAndSaveServices;

    @Scheduled(fixedRate = 60*60*1000*24)
    public void performJob(){

        System.out.println("Data updated : "+ today());
        downloadAndSaveServices.save(today());
        downloadAndSaveServices.save("2019-05-05");
        downloadAndSaveServices.save("2019-05-04");
        downloadAndSaveServices.save("2019-05-03");
        downloadAndSaveServices.save("2019-05-02");
        downloadAndSaveServices.save("2019-05-01");

    }
}
