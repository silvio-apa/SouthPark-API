package ch.wiss.southparkapi.dto;

/**
 * Data transfer object for returning South Park quote data.
 */

public record QuoteDTO (
        Long id,
        String text,
        Integer season,
        Integer episode,
        Long characterId
) {
}
