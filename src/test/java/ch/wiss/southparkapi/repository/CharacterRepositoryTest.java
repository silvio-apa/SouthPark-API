package ch.wiss.southparkapi.repository;

import ch.wiss.southparkapi.model.SouthParkCharacter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests database access for South Park characters.
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CharacterRepositoryTest {

    @Autowired
    private CharacterRepository characterRepository;

    @Test
    void saveAndFindCharacterById() {
        SouthParkCharacter character = new SouthParkCharacter(
                "Test Character",
                10,
                "Male",
                "Student",
                "Alive",
                "https://example.com/test.png"
        );

        SouthParkCharacter savedCharacter = characterRepository.save(character);

        Optional<SouthParkCharacter> foundCharacter = characterRepository.findById(savedCharacter.getId());

        assertTrue(foundCharacter.isPresent());
        assertEquals("Test Character", foundCharacter.get().getName());
        assertEquals("Alive", foundCharacter.get().getStatus());
    }
}