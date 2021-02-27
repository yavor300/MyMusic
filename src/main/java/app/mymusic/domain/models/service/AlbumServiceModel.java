package app.mymusic.domain.models.service;

import app.mymusic.domain.entities.enums.GenreEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class AlbumServiceModel {
    private String id;
    private String name;
    private String imageUrl;
    private String description;
    private Long copies;
    private BigDecimal price;
    private LocalDate releasedDate;
    private String producer;
    private GenreEnum genre;
    private ArtistServiceModel artist;
    private UserServiceModel added_from;
}
