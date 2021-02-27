package app.mymusic.service.impl;

import app.mymusic.domain.entities.Album;
import app.mymusic.domain.entities.Artist;
import app.mymusic.domain.entities.User;
import app.mymusic.domain.models.service.AlbumServiceModel;
import app.mymusic.domain.models.service.UserServiceModel;
import app.mymusic.repository.AlbumRepository;
import app.mymusic.service.AlbumService;
import app.mymusic.service.ArtistService;
import app.mymusic.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final HttpSession httpSession;
    private final ModelMapper modelMapper;
    private final ArtistService artistService;
    private final UserService userService;

    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepository, HttpSession httpSession, ModelMapper modelMapper, ArtistService artistService, UserService userService) {
        this.albumRepository = albumRepository;
        this.httpSession = httpSession;
        this.modelMapper = modelMapper;
        this.artistService = artistService;
        this.userService = userService;
    }

    @Override
    public AlbumServiceModel add(AlbumServiceModel albumServiceModel) {
        Album album = modelMapper.map(albumServiceModel, Album.class);

        Artist artist = modelMapper.map(
                artistService.findByName(album.getArtist().getName()),
                Artist.class
        );
        album.setArtist(artist);

        UserServiceModel userServiceModel = (UserServiceModel) httpSession.getAttribute("user");
        User user = modelMapper.map(userService.findById(userServiceModel.getId()),
                User.class);
        album.setAdded_from(user);

        return modelMapper.map(albumRepository.saveAndFlush(album), AlbumServiceModel.class);
    }

    @Override
    public List<AlbumServiceModel> getAllOrdered() {
        return albumRepository.findAllOrdered()
                .stream().map(album -> modelMapper.map(album, AlbumServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public Long getTotalCopiesSum() {
        return albumRepository.getTotalCopiesSum();
    }

    @Override
    public void deleteById(String id) {
        Album album = albumRepository.findById(id).orElseThrow();
        album.setAdded_from(null);
        album.setArtist(null);
        albumRepository.delete(album);
    }
}
