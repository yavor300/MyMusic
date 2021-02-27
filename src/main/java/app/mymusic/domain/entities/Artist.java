package app.mymusic.domain.entities;

import app.mymusic.domain.entities.enums.ArtistNameEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "artists")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Artist extends BaseEntity {
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ArtistNameEnum name;
    @Column(name = "career_information", columnDefinition = "LONGTEXT")
    private String careerInformation;
}
