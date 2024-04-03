package metier.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SONG")
public class Song implements Serializable{
	@Id
	@Column (name="CODE")
	private Long idSong;
	
	@Column (name="NAMESONG")
	private String nameSong;
	
	@Column (name="NAMESINGER")
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
