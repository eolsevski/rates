package com.accounting.currencies.model.repository;

import com.accounting.currencies.model.FxRate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FxRateRepository extends CrudRepository<FxRate, Long> {
    @Query("SELECT f FROM FxRate f WHERE f.dt = :dt")
    List<FxRate> findByDt(@Param("dt") String dt);
}
