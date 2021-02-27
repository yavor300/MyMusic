package app.mymusic.domain.entities;

import app.mymusic.domain.entities.enums.GenreEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "albums")
@Getter
@Setter
@NoArgsConstructor
public class Album extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column(name = "image_url", nullable = false)
    private String imageUrl;
    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String description;
    @Column(nullable = false)
    private Long copies;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(name = "released_date", nullable = false)
    private LocalDate releasedDate;
    @Column
    private String producer;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GenreEnum genre;
    @ManyToOne
    private Artist artist;
    @ManyToOne
    private User added_from;
}
