package ch.wiss.southparkapi.controller;

import ch.wiss.southparkapi.dto.CharacterDTO;
import ch.wiss.southparkapi.dto.CharacterFormDTO;
import ch.wiss.southparkapi.service.CharacterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public CharacterDTO createCharacter(@Valid @RequestBody CharacterFormDTO formDTO) {
        return characterService.createCharacter(formDTO);
    }


    @PutMapping("/{id}")
    public CharacterDTO updateCharacter(@PathVariable Long id, @Valid @RequestBody CharacterFormDTO formDTO) {
        return characterService.updateCharacter(id, formDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacter(id);
    }
}
