package ch.wiss.southparkapi.controller;

import ch.wiss.southparkapi.dto.CharacterDTO;
import ch.wiss.southparkapi.dto.CharacterFormDTO;
import ch.wiss.southparkapi.service.CharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Provides REST endpoints for South Park characters.
 */

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public List<CharacterDTO> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    @GetMapping("/{id}")
    public CharacterDTO getCharacterById(@PathVariable Long id) {
        return characterService.getCharacterById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CharacterDTO createCharacter(@RequestBody CharacterFormDTO formDTO) {
        return characterService.createCharacter(formDTO);
    }
}
