package com.accounting.currencies;

import com.accounting.currencies.model.CcyAmt;
import com.accounting.currencies.model.FxRate;
import com.accounting.currencies.model.repository.FxRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.stream.Collectors;

import static com.accounting.currencies.Services.DateService.today;


@Controller
public class controller {

    @Autowired
    FxRateRepository fxRateRepository;

    @GetMapping("/")
    private String welcome() {

        return "welcome";
    }
    @PostMapping("/showCurrencies")
    private String showCurrencies() {

        return "welcome";
    }

    @GetMapping("/showCurrencies")
    private ModelAndView showTodayCurrencies( ) {

        String dt=today();

        List<FxRate> rates = (List<FxRate>)fxRateRepository.findAll();

        List<CcyAmt> amts =
        rates
                .stream()
                .filter(s->s.getDt().equals(dt))
                .map(p->p.getAtms().get(1))
                .collect(Collectors.toList());

        Set<String> countries = rates
                .stream()
                .map(p->p.getAtms().get(1).getCcy())
                .collect(Collectors.toSet());

        Map<String, Object> params = new HashMap<>();
        params.put("rates", amts);
        params.put("countries", countries);

        return new ModelAndView("rates", params);
    }

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

        System.out.println(result);
        Map<String, Object> params = new HashMap<>();
        params.put("results", result);
//        params.put("country", country);

        return new ModelAndView("history", params);
    }



}
