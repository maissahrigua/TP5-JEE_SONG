package test;
import java.util.List;

import dao.SongDaoImpl;
import metier.entities.Song;

public class TestDao {

	public static void main(String[] args) {
		SongDaoImpl sdao= new SongDaoImpl();
		Song so= sdao.save(new Song("Betty","Taylor Swift"));
		System.out.println(so);
		List<Song> songs =sdao.songsParMC("Tay");
		for (Song s : songs)
		System.out.println(s);

	}

}
