package com.accounting.currencies.model.repository;

import com.accounting.currencies.model.CcyAmt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CcyAtmRepository extends CrudRepository<CcyAmt, Long> {
}
