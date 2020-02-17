package fr.webnet.test.infrastructure.language;

import fr.webnet.test.infrastructure.language.dto.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface LanguageRepository extends JpaRepository<LanguageEntity, Integer> {

}
