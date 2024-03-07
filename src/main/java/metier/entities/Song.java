package metier.entities;
import java.io.Serializable;
public class Song implements Serializable{
	private Long idSong;
	private String nameSong;
	private String nameSinger;
	
	public Song() {
		super();
	}
	
	public Song(String nameSong, String nameSinger) {
		super();
		this.nameSong = nameSong;
		this.nameSinger = nameSinger;
	}

	public Long getIdSong() {
		return idSong;
	}
	public void setIdSong(Long idSong) {
		this.idSong = idSong;
	}
	public String getNameSong() {
		return nameSong;
	}
	public void setNameSong(String nameSong) {
		this.nameSong = nameSong;
	}
	public String getNameSinger() {
		return nameSinger;
	}
	public void setNameSinger(String nameSinger) {
		this.nameSinger = nameSinger;
	}
	@Override
	public String toString() {
		return "Song [idSong=" + idSong + ", nameSong=" + nameSong + ", nameSinger=" + nameSinger + "]";
	}
	
}
