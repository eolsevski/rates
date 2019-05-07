package com.accounting.currencies.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class FxRates {
    @Id
    @GeneratedValue
    private Long id;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JsonProperty("FxRate")
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "fxrate_id")
    private List<FxRate> fxRateList;

}
