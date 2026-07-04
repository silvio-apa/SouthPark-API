package ch.wiss.southparkapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Data transfer object for creating and updating South Park quotes.
 */
public record QuoteFormDTO(

        @NotBlank(message = "Quote text must not be empty")
        @Size(max = 500, message = "Quote text must contain no more than 500 characters")
        String text,

        @Min(value = 1, message = "Season must be at least 1")
        Integer season,

        @Min(value = 1, message = "Episode must be at least 1")
        Integer episode
) {
}
