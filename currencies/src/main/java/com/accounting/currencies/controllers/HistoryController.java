package com.accounting.currencies.controllers;

import com.accounting.currencies.model.FxRate;
import com.accounting.currencies.model.repository.FxRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class HistoryController {


    @Autowired
    FxRateRepository fxRateRepository;

    @PostMapping("/history")
    private ModelAndView showHistory(@RequestParam String country){

        List<FxRate> rates = (List<FxRate>)fxRateRepository.findAll();

        Map<String, Float> result =
                rates
                        .stream()
                        .filter(s->s.getAtms().get(1).getCcy().equals(country))
                        .distinct()
                        .collect(Collectors.toMap(
                                p->p.getDt(),
                                p->p.getAtms().get(1).getAmt(),
                                (Dt1,Dt2)->{return Dt1;}
                        ));

        Map<String, Object> params = new HashMap<>();
        params.put("results", result);
        params.put("country", country);

        return new ModelAndView("history", params);
    }
}
