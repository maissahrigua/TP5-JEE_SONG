package web;
import java.util.ArrayList;
import java.util.List;
import metier.entities.Song;
public class ProduitModele {
	private String motCle;
	List<Song> songs = new ArrayList<>();
	public String getMotCle() {
	return motCle;
	}
	public void setMotCle(String motCle) {
	this.motCle = motCle;
	}
	public List<Song> getSongs() {
	return songs;
	}
	public void setSongs(List<Song> songs) {
	this.songs = songs;
	}

}
