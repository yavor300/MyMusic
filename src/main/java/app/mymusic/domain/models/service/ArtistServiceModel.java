package app.mymusic.domain.models.service;

import app.mymusic.domain.entities.enums.ArtistNameEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ArtistServiceModel {
    private String id;
    private ArtistNameEnum name;
    private String careerInformation;
}
