package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.SingletonConnection;
import metier.entities.Song;
public class SongDaoImpl implements ISongDao{
	@Override
	public Song save(Song s) {
	Connection conn=SingletonConnection.getConnection();
	 try {
	PreparedStatement ps= conn.prepareStatement("INSERT INTO songs(NOM_SONG,NOM_SINGER) VALUES(?,?)");
	ps.setString(1, s.getNameSong());
	ps.setString(1, s.getNameSinger());
	ps.executeUpdate();
	PreparedStatement ps2= conn.prepareStatement("SELECT MAX(ID_SONG) as MAX_ID FROM songs");
	ResultSet rs =ps2.executeQuery();
	if (rs.next()) {
	s.setIdSong(rs.getLong("MAX_ID"));
	}
	ps.close();
	ps2.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return s;
	}
	@Override
	public List<Song> songsParMC(String mc) {
	 List<Song> songs= new ArrayList<Song>();
	 Connection conn=SingletonConnection.getConnection();
	 try {
	PreparedStatement ps= conn.prepareStatement("select * from songs where NOM_SONG LIKE ?");
	ps.setString(1, "%"+mc+"%");
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
	Song s = new Song();
	s.setIdSong(rs.getLong("ID_SONG"));
	s.setNameSong(rs.getString("NOM_SONG"));
	s.setNameSinger(rs.getString("NOM_SINGER"));
	songs.add(s);
	}
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return songs;
	}
	@Override
	public Song getSong(Long id) {
	 
	 Connection conn=SingletonConnection.getConnection();
	 Song s = new Song();
	 try {
	PreparedStatement ps= conn.prepareStatement("select * from SONGS where ID_SONG = ?");
	ps.setLong(1, id);
	ResultSet rs = ps.executeQuery();
	if (rs.next()) {
	s.setIdSong(rs.getLong("ID_SONG"));
	s.setNameSong(rs.getString("NOM_SONG"));
	s.setNameSinger(rs.getString("NOM_SiNGER"));
	}
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return s;
	}
	@Override
	public Song updateSong(Song s) {
	Connection conn=SingletonConnection.getConnection();
	 try {
	PreparedStatement ps= conn.prepareStatement("UPDATE SONGS SET NOM_SONG=?,NOM_SINGER=? WHERE ID_SONG=?");
	ps.setString(1,s.getNameSong());
	ps.setString(2, s.getNameSinger());
	ps.setLong(3, s.getIdSong());
	ps.executeUpdate();
	ps.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return s;
	}
	@Override
	public void deleteSong(Long id) {
	Connection conn=SingletonConnection.getConnection();
	 try {
	PreparedStatement ps= conn.prepareStatement("DELETE FROM SONGS WHERE ID_SONG = ?");
	ps.setLong(1, id);
	ps.executeUpdate();
	ps.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	}

	}
