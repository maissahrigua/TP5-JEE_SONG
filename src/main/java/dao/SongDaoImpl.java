package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Song;
import util.JPAutil;

public class SongDaoImpl implements ISongDao {
	private EntityManager entityManager = JPAutil.getEntityManager("TP5_SONG");

	@Override
	public Song save(Song s) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(s);
		tx.commit();
		return s;
	}

	@Override
	public List<Song> songsParMC(String mc) {
		List<Song> prods =
				entityManager.createQuery("select s from Song s where s.namesong like :mc").setParameter("mc", "%"+mc+"%").getResultList();
						return prods;
	}

	@Override
	public Song getSong(Long id) {
		return entityManager.find(Song.class, id);
	}

	@Override
	public Song updateSong(Song s) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(s);
		tx.commit();
		return s;
	}

	@Override
	public void deleteSong(Long id) {
		Song song = entityManager.find(Song.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(song);
		entityManager.getTransaction().commit();
	}
}