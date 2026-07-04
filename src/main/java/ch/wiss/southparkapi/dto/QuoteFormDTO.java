package ch.wiss.southparkapi.dto;

public record QuoteFormDTO(
        String text,
        Integer season,
        Integer episode
) {
}
