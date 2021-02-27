package app.mymusic.repository;

import app.mymusic.domain.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, String > {
    @Query("SELECT a FROM Album a ORDER BY a.copies DESC")
    List<Album> findAllOrdered();

    @Query("SELECT SUM(a.copies) FROM Album a")
    Long getTotalCopiesSum();
}
