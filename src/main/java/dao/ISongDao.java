package dao;
import java.util.List;
import metier.entities.Song;

public interface ISongDao {
	public Song save(Song s);
	public List<Song> songsParMC(String mc);
	public Song getSong(Long id);
	public Song updateSong(Song s);
	public void deleteSong(Long id);

}
