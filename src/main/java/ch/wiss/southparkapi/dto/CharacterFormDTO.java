package ch.wiss.southparkapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Data transfer object for creating and updating South Park characters.
 */

public record CharacterFormDTO(

        @NotBlank(message = "Name must not be empty")
        @Size(max = 100, message = "Name must contain no more than 100 characters")
        String name,

        @Min(value = 0, message = "Age must be at least 0")
        Integer age,

        @NotBlank(message = "Gender must not be empty")
        @Size(max = 50, message = "Gender must contain no more than 50 characters")
        String gender,

        @Size(max = 100, message = "Occupation must contain no more than 100 characters")
        String occupation,

        @NotBlank(message = "Status must not be empty")
        @Size(max = 50, message = "Status must contain no more than 50 characters")
        String status,
        String imageUrl
) {
}