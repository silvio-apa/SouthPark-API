package ch.wiss.southparkapi.dto;


/**
 * Data transfer object for returning Southpark character data.
 */

public record CharacterDTO(
        Long id,
        String name,
        Integer age,
        String gender,
        String occupation,
        String status,
        String imageUrl
) {

}

