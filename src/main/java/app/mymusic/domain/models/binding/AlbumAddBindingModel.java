package app.mymusic.domain.models.binding;

import app.mymusic.domain.entities.enums.ArtistNameEnum;
import app.mymusic.domain.entities.enums.GenreEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class AlbumAddBindingModel {
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    private String name;
    @Size(min = 5, message = "Image url must be minimum 5 characters")
    private String imageUrl;
    @NotNull(message = "Price must be positive number")
    @Positive(message = "Price must be positive number")
    private BigDecimal price;
    @NotNull(message = "Copies must be more than 10")
    @Min(value = 10, message = "Copies must be more than 10")
    private Long copies;
    @NotNull(message = "Release date cannot be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Release date cannot be in the future")
    private LocalDate releasedDate;
    private String producer;
    @NotNull(message = "You must select artist")
    private ArtistNameEnum artist;
    @NotNull(message = "You must select genre")
    private GenreEnum genre;
    @Size(min = 5, message = "Description length must be minimum 5 characters")
    private String description;
}
