package me.gabreuw.stockquotesapi;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    @RestResource(rel = "quotes", path = "quotes")
    Page<Quote> findAllBySymbol(@Param("symbol") String symbol, Pageable page);

    Optional<Quote> findFirstBySymbolOrderByTimestampDesc(String symbol);

}