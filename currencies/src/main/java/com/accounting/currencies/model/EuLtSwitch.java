package com.accounting.currencies.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class EuLtSwitch
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(
            name = "country",
            columnDefinition = "ENUM('LT','EU')",
            nullable = false
    )
    private countrySwitch country;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "fxrates_id")
    private List<FxRates> fxRatesList;

    public enum countrySwitch{
        LT,
        EU;
    }
}

