package com.accounting.currencies.Services;

import com.accounting.currencies.model.FxRates;
import com.accounting.currencies.model.repository.FxRatesRepository;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class RateServices {

    @Autowired
    FxRatesRepository fxRatesRepository;

    public void save (String dt){

        final String uri = "http://old.lb.lt/webservices/FxRates/FxRates.asmx/getFxRates?tp=EU&dt="+dt;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        XmlMapper xmlMapper = new XmlMapper();
        try {
            FxRates value = xmlMapper.readValue(result, FxRates.class);
            fxRatesRepository.save(value);
        }catch (IOException e) {
            System.out.println(e);
        }
    }
}
