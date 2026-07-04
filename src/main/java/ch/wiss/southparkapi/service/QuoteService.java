package ch.wiss.southparkapi.service;

import ch.wiss.southparkapi.dto.QuoteDTO;
import ch.wiss.southparkapi.dto.QuoteFormDTO;
import ch.wiss.southparkapi.mapper.QuoteMapper;
import ch.wiss.southparkapi.model.Quote;
import ch.wiss.southparkapi.model.SouthParkCharacter;
import ch.wiss.southparkapi.repository.CharacterRepository;
import ch.wiss.southparkapi.repository.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Contains the business logic for South Park quotes.
 */

@Service
public class QuoteService {

    private final QuoteRepository quoteRepository;
    private final CharacterRepository characterRepository;
    private final QuoteMapper quoteMapper;

    public QuoteService(QuoteRepository quoteRepository, CharacterRepository characterRepository, QuoteMapper quoteMapper) {
        this.quoteRepository = quoteRepository;
        this.characterRepository = characterRepository;
        this.quoteMapper = quoteMapper;
    }

    public List<QuoteDTO> getAllQuotes() {
        return quoteRepository.findAll()
                .stream()
                .map(quoteMapper::toDTO)
                .toList();
    }

    public QuoteDTO getQuoteById(Long id) {
        Quote quote = quoteRepository.findById(id)
                .orElseThrow();

        return quoteMapper.toDTO(quote);
    }

    public List<QuoteDTO> getQuotesByCharacterId(Long characterId) {
        return quoteRepository.findByCharacterId(characterId)
                .stream()
                .map(quoteMapper::toDTO)
                .toList();
    }


    public QuoteDTO createQuote(Long characterId, QuoteFormDTO formDTO) {
        SouthParkCharacter character = characterRepository.findById(characterId)
                .orElseThrow();

        Quote quote = quoteMapper.toEntity(formDTO, character);
        Quote savedQuote = quoteRepository.save(quote);

        return quoteMapper.toDTO(savedQuote);
    }

    public QuoteDTO updateQuote(Long id, QuoteFormDTO formDTO) {
        Quote quote = quoteRepository.findById(id)
                .orElseThrow();

        quoteMapper.updateEntity(quote, formDTO);
        Quote savedQuote = quoteRepository.save(quote);

        return quoteMapper.toDTO(savedQuote);
    }

    public void deleteQuote(Long id) {
        Quote quote = quoteRepository.findById(id)
                .orElseThrow();

        quoteRepository.delete(quote);
    }
}