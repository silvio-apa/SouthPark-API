package ch.wiss.southparkapi.mapper;


import ch.wiss.southparkapi.dto.CharacterDTO;
import ch.wiss.southparkapi.dto.CharacterFormDTO;
import ch.wiss.southparkapi.model.SouthParkCharacter;
import org.springframework.stereotype.Component;

/**
 * Maps SouthParkCharacter entities to DTOs and form DTOs to entities.
 */

@Component
public class CharacterMapper {

    public CharacterDTO toDTO(SouthParkCharacter character) {
        return new CharacterDTO(
                character.getId(),
                character.getName(),
                character.getAge(),
                character.getGender(),
                character.getOccupation(),
                character.getStatus(),
                character.getImageUrl()
        );

    }


    public SouthParkCharacter toEntity(CharacterFormDTO formDTO) {
        return new SouthParkCharacter(
                formDTO.name(),
                formDTO.age(),
                formDTO.gender(),
                formDTO.occupation(),
                formDTO.status(),
                formDTO.imageUrl()
        );
    }


    public void updateEntity(SouthParkCharacter character, CharacterFormDTO formDTO) {
        character.setName(formDTO.name());
        character.setAge(formDTO.age());
        character.setGender(formDTO.gender());
        character.setOccupation(formDTO.occupation());
        character.setStatus(formDTO.status());
        character.setImageUrl(formDTO.imageUrl());

    }

}



