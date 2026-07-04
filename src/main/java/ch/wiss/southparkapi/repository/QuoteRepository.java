package ch.wiss.southparkapi.repository;

import ch.wiss.southparkapi.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Provides database access for South Park character quotes.
 */

public interface QuoteRepository extends JpaRepository<Quote, Long> {
    List<Quote> findByCharacterId(Long characterId);
}
