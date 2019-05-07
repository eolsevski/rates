package com.accounting.currencies.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class CcyAmt {
    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty("Ccy")
    private String Ccy;
    @JsonProperty("Amt")
    private float Amt;

}
