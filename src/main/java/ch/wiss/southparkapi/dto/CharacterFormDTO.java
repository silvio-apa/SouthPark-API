package ch.wiss.southparkapi.dto;

/**
 * Data transfer object for creating and updating South Park characters.
 */

public record CharacterFormDTO(
        String name,
        Integer age,
        String gender,
        String occupation,
        String status,
        String imageUrl
  ) {
}