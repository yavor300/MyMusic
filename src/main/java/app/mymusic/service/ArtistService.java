package app.mymusic.service;

import app.mymusic.domain.entities.enums.ArtistNameEnum;
import app.mymusic.domain.models.service.ArtistServiceModel;

public interface ArtistService {
    void init();

    ArtistServiceModel findByName(ArtistNameEnum name);
}
