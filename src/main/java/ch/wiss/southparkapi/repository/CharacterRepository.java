package ch.wiss.southparkapi.repository;


import ch.wiss.southparkapi.model.SouthParkCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides database access for South Park characters.
 */
public interface  CharacterRepository extends JpaRepository<SouthParkCharacter, Long> {
}
