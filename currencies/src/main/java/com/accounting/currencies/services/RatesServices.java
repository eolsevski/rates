package com.accounting.currencies.services;

import com.accounting.currencies.model.EuLtSwitch;
import com.accounting.currencies.model.FxRates;
import com.accounting.currencies.model.repository.EuLtSwitchRepository;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RatesServices {

    @Autowired
    EuLtSwitchRepository euLtSwitchRepository;

    public void save (String tp, String dt){

        EuLtSwitch euLtSwitch = new EuLtSwitch();
        List<FxRates> fxRatesList = new ArrayList<>();

        switch(tp){
            case "LT":
                euLtSwitch.setCountry(EuLtSwitch.countrySwitch.LT);
                break;
            case"EU":
                euLtSwitch.setCountry(EuLtSwitch.countrySwitch.EU);
            default:
//                todo exception

        }

        final String uri = "http://old.lb.lt/webservices/FxRates/FxRates.asmx/getFxRates?tp="+tp+"&dt="+dt;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        XmlMapper xmlMapper = new XmlMapper();

        try {
            FxRates value = xmlMapper.readValue(result, FxRates.class);
            fxRatesList.add(value);
            euLtSwitch.setFxRatesList(fxRatesList);
            euLtSwitchRepository.save(euLtSwitch);
        }catch (IOException e) {
            System.out.println(e);
        }
    }
}
