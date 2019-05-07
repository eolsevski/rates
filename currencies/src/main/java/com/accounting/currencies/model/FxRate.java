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
public class FxRate {
    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty("Tp")
    private String tp;
    @JsonProperty("Dt")
    private String dt;
    @JsonProperty("CcyAmt")
    @JacksonXmlElementWrapper(useWrapping = false)
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "ccyamt_id")
    private List<CcyAmt> atms;

}
