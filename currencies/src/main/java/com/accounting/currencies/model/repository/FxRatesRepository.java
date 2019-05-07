package com.accounting.currencies.model.repository;

import com.accounting.currencies.model.FxRates;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FxRatesRepository extends CrudRepository<FxRates, Long> {
}
