package com.accounting.currencies.controllers;

import com.accounting.currencies.model.CcyAmt;
import com.accounting.currencies.model.FxRate;
import com.accounting.currencies.model.repository.FxRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.accounting.currencies.services.DateService.yesterday;

@Controller
public class WelcomeController {

    @Autowired
    FxRateRepository fxRateRepository;

    @RequestMapping("/")
    private ModelAndView welcome(
            @RequestParam(required = false)
                    String country,
                    Float amount){

        if(amount==null)amount=0f;
        String dt=yesterday();

        List<FxRate>rates = (List<FxRate>)fxRateRepository.findAll();

        List<CcyAmt> amts =
                rates
                        .stream()
                        .filter(s->s.getDt().equals(dt))
                        .map(p->p.getAtms().get(1))
                        .collect(Collectors.toList()
                        );

        float res=0f;

        for( CcyAmt atm: amts )
        {
            if (atm.getCcy().equals(country))
                res=atm.getAmt()*amount;
        }

        Set<String> countries = rates
                .stream()
                .filter(s->s.getDt().equals(dt))
                .map(p->p.getAtms().get(1).getCcy())
                .collect(Collectors.toSet());

        Map<String, Object> params = new HashMap<>();
        params.put("rates", amts);
        params.put("countries", countries);
        params.put("res", res);
        return new ModelAndView("welcome", params);
    }
}
