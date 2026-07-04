package ch.wiss.southparkapi.dto;

import java.util.List;

/**
 * Data transfer object for returning API error responses.
 */

public record ErrorResponseDTO(
        int status,
        String message,
        List<String> errors
) {
}