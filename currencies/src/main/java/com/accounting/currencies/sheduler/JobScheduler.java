package com.accounting.currencies.sheduler;

import com.accounting.currencies.services.RatesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import static com.accounting.currencies.services.DateService.today;

@Service
public class JobScheduler {

    @Autowired
    RatesServices downloadAndSaveRates;

    @Scheduled(fixedRate = 60*60*1000*24)
    public void performJob(){

        System.out.println("Data updated : "+ today());
        downloadAndSaveRates.save("LT",today());
        downloadAndSaveRates.save("EU",today());
        downloadAndSaveRates.save("LT","2019-05-05");
        downloadAndSaveRates.save("EU","2019-05-05");
        downloadAndSaveRates.save("LT","2019-05-03");
        downloadAndSaveRates.save("EU","2019-05-03");
        downloadAndSaveRates.save("LT","2019-05-07");
        downloadAndSaveRates.save("EU","2019-05-07");
    }
}
