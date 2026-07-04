package ch.wiss.southparkapi.controller;

import ch.wiss.southparkapi.dto.QuoteDTO;
import ch.wiss.southparkapi.dto.QuoteFormDTO;
import ch.wiss.southparkapi.service.QuoteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Provides REST endpoints for South Park quotes.
 */

@RestController
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/api/quotes")
    public List<QuoteDTO> getAllQuotes() {
        return quoteService.getAllQuotes();
    }

    @GetMapping("/api/quotes/{id}")
    public QuoteDTO getQuoteById(@PathVariable Long id) {
        return quoteService.getQuoteById(id);
    }

    @GetMapping("/api/characters/{characterId}/quotes")
    public List<QuoteDTO> getQuotesByCharacterId(@PathVariable Long characterId) {
        return quoteService.getQuotesByCharacterId(characterId);
    }

    @PostMapping("/api/characters/{characterId}/quotes")
    @ResponseStatus(HttpStatus.CREATED)
    public QuoteDTO createQuote(@PathVariable Long characterId, @Valid @RequestBody QuoteFormDTO formDTO) {
        return quoteService.createQuote(characterId, formDTO);
    }

    @PutMapping("/api/quotes/{id}")
    public QuoteDTO updateQuote(@PathVariable Long id, @Valid @RequestBody QuoteFormDTO formDTO) {
        return quoteService.updateQuote(id, formDTO);
    }

    @DeleteMapping("/api/quotes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuote(@PathVariable Long id) {
        quoteService.deleteQuote(id);
    }
}