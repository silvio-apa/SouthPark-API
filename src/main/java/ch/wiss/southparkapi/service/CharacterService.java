package ch.wiss.southparkapi.service;


import ch.wiss.southparkapi.dto.CharacterDTO;
import ch.wiss.southparkapi.dto.CharacterFormDTO;
import ch.wiss.southparkapi.mapper.CharacterMapper;
import ch.wiss.southparkapi.model.SouthParkCharacter;
import ch.wiss.southparkapi.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Contains the business logic for South Park Charakter.
 */

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final CharacterMapper characterMapper;

    public CharacterService(CharacterRepository characterRepository, CharacterMapper characterMapper) {
        this.characterRepository = characterRepository;
        this.characterMapper = characterMapper;
    }

    public List<CharacterDTO> getAllCharacters() {
        return characterRepository.findAll().stream().map(characterMapper::toDTO).toList();
    }

    public CharacterDTO getCharacterById(Long id) {
        SouthParkCharacter character = characterRepository.findById(id).orElseThrow();

        return characterMapper.toDTO(character);
    }

    public CharacterDTO createCharacter(CharacterFormDTO formDTO) {
        SouthParkCharacter character = characterMapper.toEntity(formDTO);
        SouthParkCharacter savedCharacter = characterRepository.save(character);

        return characterMapper.toDTO(savedCharacter);
    }


    public CharacterDTO updateCharacter(Long id, CharacterFormDTO formDTO) {
        SouthParkCharacter character = characterRepository.findById(id).orElseThrow();

        characterMapper.updateEntity(character, formDTO);
        SouthParkCharacter savedCharacter = characterRepository.save(character);

        return characterMapper.toDTO(savedCharacter);

    }

    public void deleteCharacter(Long id) {
        SouthParkCharacter character = characterRepository.findById(id).orElseThrow();

        characterRepository.delete(character);

    }
}
