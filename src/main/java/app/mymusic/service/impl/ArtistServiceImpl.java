package app.mymusic.service.impl;

import app.mymusic.domain.entities.Artist;
import app.mymusic.domain.entities.enums.ArtistNameEnum;
import app.mymusic.domain.models.service.ArtistServiceModel;
import app.mymusic.repository.ArtistRepository;
import app.mymusic.service.ArtistService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;
    private final ModelMapper modelMapper;

    public ArtistServiceImpl(ArtistRepository artistRepository, ModelMapper modelMapper) {
        this.artistRepository = artistRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void init() {
        if (artistRepository.count() == 0) {
            Arrays.stream(ArtistNameEnum.values())
                    .forEach(artistNameEnum -> {
                        Artist artist = new Artist(artistNameEnum, null);
                        artistRepository.saveAndFlush(artist);
                    });
        }
    }

    @Override
    public ArtistServiceModel findByName(ArtistNameEnum name) {
        return modelMapper.map(artistRepository.findByName(name), ArtistServiceModel.class);
    }
}
