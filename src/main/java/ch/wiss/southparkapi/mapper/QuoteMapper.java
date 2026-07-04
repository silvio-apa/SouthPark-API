package ch.wiss.southparkapi.mapper;


import ch.wiss.southparkapi.dto.QuoteDTO;
import ch.wiss.southparkapi.dto.QuoteFormDTO;
import ch.wiss.southparkapi.model.Quote;
import ch.wiss.southparkapi.model.SouthParkCharacter;
import org.springframework.stereotype.Component;

/**
 * Maps Quote entities to DTOs and form DTOs to entities.
 */

@Component
public class QuoteMapper {

    public QuoteDTO toDTO(Quote quote) {
        return new QuoteDTO(
                quote.getId(),
                quote.getText(),
                quote.getSeason(),
                quote.getEpisode(),
                quote.getCharacter().getId()
        );

    }

    public Quote toEntity(QuoteFormDTO formDTO, SouthParkCharacter character) {
        return new Quote(
                formDTO.text(),
                formDTO.season(),
                formDTO.episode(),
                character
        );
    }


    public void updateEntity(Quote quote, QuoteFormDTO formDTO) {
        quote.setText(formDTO.text());
        quote.setSeason(formDTO.season());
        quote.setEpisode(formDTO.episode());
    }

}
