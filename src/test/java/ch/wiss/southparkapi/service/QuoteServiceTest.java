package ch.wiss.southparkapi.service;

import ch.wiss.southparkapi.dto.QuoteDTO;
import ch.wiss.southparkapi.dto.QuoteFormDTO;
import ch.wiss.southparkapi.mapper.QuoteMapper;
import ch.wiss.southparkapi.model.Quote;
import ch.wiss.southparkapi.model.SouthParkCharacter;
import ch.wiss.southparkapi.repository.CharacterRepository;
import ch.wiss.southparkapi.repository.QuoteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Tests the business logic for South Park quotes.
 */

@ExtendWith(MockitoExtension.class)
public class QuoteServiceTest {

    @Mock
    private QuoteRepository quoteRepository;

    @Mock
    private CharacterRepository characterRepository;

    @Mock
    private QuoteMapper quoteMapper;

    @InjectMocks
    private QuoteService quoteService;

    @Test
    void createQuoteAddsQuoteToCharacter() {
        SouthParkCharacter character = new SouthParkCharacter(
                "Eric Cartman",
                10,
                "Male",
                "Student",
                "Alive",
                "https://example.com/cartman.png"
        );
        character.setId(1L);

        QuoteFormDTO formDTO = new QuoteFormDTO(
                "Respect my authority!",
                2,
                4
        );

        Quote quote = new Quote(
                "Respect my authority!",
                2,
                4,
                character
        );

        Quote savedQuote = new Quote(
                "Respect my authority!",
                2,
                4,
                character
        );
        savedQuote.setId(1L);

        QuoteDTO quoteDTO = new QuoteDTO(
                1L,
                "Respect my authority!",
                2,
                4,
                1L
        );

        when(characterRepository.findById(1L)).thenReturn(Optional.of(character));
        when(quoteMapper.toEntity(formDTO, character)).thenReturn(quote);
        when(quoteRepository.save(quote)).thenReturn(savedQuote);
        when(quoteMapper.toDTO(savedQuote)).thenReturn(quoteDTO);

        QuoteDTO result = quoteService.createQuote(1L, formDTO);

        assertEquals(1L, result.id());
        assertEquals("Respect my authority!", result.text());
        assertEquals(1L, result.characterId());
    }
}