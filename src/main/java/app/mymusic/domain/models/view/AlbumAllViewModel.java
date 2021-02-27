package app.mymusic.domain.models.view;

import app.mymusic.domain.entities.enums.ArtistNameEnum;
import app.mymusic.domain.entities.enums.GenreEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class AlbumAllViewModel {
    private String id;
    private String name;
    private String imageUrl;
    private Long copies;
    private BigDecimal price;
    private LocalDate releasedDate;
    private GenreEnum genre;
    private ArtistNameEnum artistName;
}
