package ch.wiss.southparkapi.service;

import ch.wiss.southparkapi.dto.CharacterDTO;
import ch.wiss.southparkapi.exception.ResourceNotFoundException;
import ch.wiss.southparkapi.mapper.CharacterMapper;
import ch.wiss.southparkapi.model.SouthParkCharacter;
import ch.wiss.southparkapi.repository.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * Tests the business logic for South Park characters.
 */

@ExtendWith(MockitoExtension.class)
public class CharacterServiceTest {

    @Mock
    private CharacterRepository characterRepository;

    @Mock
    private CharacterMapper characterMapper;

    @InjectMocks
    private CharacterService characterService;

    @Test
    void getCharacterByIdReturnsCharacter() {
        SouthParkCharacter character = new SouthParkCharacter(
                "Eric Cartman",
                10,
                "Male",
                "Student",
                "Alive",
                "https://example.com/cartman.png"
        );
        character.setId(1L);

        CharacterDTO characterDTO = new CharacterDTO(
                1L,
                "Eric Cartman",
                10,
                "Male",
                "Student",
                "Alive",
                "https://example.com/cartman.png"
        );

        when(characterRepository.findById(1L)).thenReturn(Optional.of(character));
        when(characterMapper.toDTO(character)).thenReturn(characterDTO);

        CharacterDTO result = characterService.getCharacterById(1L);

        assertEquals(1L, result.id());
        assertEquals("Eric Cartman", result.name());
        assertEquals("Alive", result.status());
    }


    @Test
    void getCharacterByIdThrowsExceptionWhenCharacterDoesNotExist() {
        when(characterRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> characterService.getCharacterById(99L));
    }
}