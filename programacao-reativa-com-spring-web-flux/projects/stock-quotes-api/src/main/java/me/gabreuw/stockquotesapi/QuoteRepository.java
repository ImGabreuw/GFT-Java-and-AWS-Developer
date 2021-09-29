package me.gabreuw.stockquotesapi;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface QuoteRepository extends PagingAndSortingRepository<Quote, Long> {

    @RestResource(rel = "quotes", path = "quotes")
    Page<Quote> findAllBySymbol(@Param("symbol") String symbol, Pageable page);

}