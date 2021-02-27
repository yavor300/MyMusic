package app.mymusic.repository;

import app.mymusic.domain.entities.Artist;
import app.mymusic.domain.entities.enums.ArtistNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, String> {
    Artist findByName(ArtistNameEnum artistNameEnum);
}
