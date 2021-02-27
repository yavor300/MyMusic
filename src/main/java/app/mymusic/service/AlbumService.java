package app.mymusic.service;

import app.mymusic.domain.models.service.AlbumServiceModel;

import java.util.List;

public interface AlbumService {
    AlbumServiceModel add(AlbumServiceModel albumServiceModel);

    List<AlbumServiceModel> getAllOrdered();

    Long getTotalCopiesSum();

    void deleteById(String id);
}
