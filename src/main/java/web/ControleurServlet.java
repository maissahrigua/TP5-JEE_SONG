package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ISongDao;
import dao.SongDaoImpl;
import metier.entities.Song;
import org.apache.catalina.connector.Response;
@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet {
	ISongDao metier;
@Override
public void init() throws ServletException {
metier = new SongDaoImpl();
}
@Override
protected void doGet(HttpServletRequest request,
 HttpServletResponse response) 
 throws ServletException, IOException {
String path=request.getServletPath();
if (path.equals("/index.do"))
{
request.getRequestDispatcher("songs.jsp").forward(request,response);
}
else if (path.equals("/chercher.do"))
{
String motCle=request.getParameter("motCle");
ProduitModele model= new ProduitModele();
model.setMotCle(motCle);
List<Song> songs = metier.songsParMC(motCle);
model.setSongs(songs);
request.setAttribute("model", model);
request.getRequestDispatcher("songs.jsp").forward(request,response);
}
else if (path.equals("/saisie.do") )
{
request.getRequestDispatcher("saisieSong.jsp").forward(request,response);
}
else if (path.equals("/save.do") && request.getMethod().equals("POST"))
{
 String nom=request.getParameter("nom");
 String name=request.getParameter("name");
Song s = metier.save(new Song(nom,name));
request.setAttribute("song", s);
request.getRequestDispatcher("confirmation.jsp").forward(request,response);
}
else if (path.equals("/supprimer.do"))
{
 Long id= Long.parseLong(request.getParameter("id"));
 metier.deleteSong(id);
 response.sendRedirect("chercher.do?motCle=");
}
else if (path.equals("/editer.do") )
{
Long id= Long.parseLong(request.getParameter("id"));
 Song s = metier.getSong(id);
 request.setAttribute("song", s);
request.getRequestDispatcher("editerSong.jsp").forward(request,response);
}
else if (path.equals("/update.do") )
{
Long id = Long.parseLong(request.getParameter("id"));
String nom=request.getParameter("nom");
String name=request.getParameter("name");
Song s = new Song();
s.setIdSong(id);
s.setNameSong(nom);
s.setNameSinger(name);
metier.updateSong(s);
request.setAttribute("song", s);
request.getRequestDispatcher("confirmation.jsp").forward(request,response);
}
else
{
response.sendError(Response.SC_NOT_FOUND);
}
}
@Override
protected void doPost(HttpServletRequest request, 
 HttpServletResponse response) throws 
ServletException, IOException {
doGet(request,response);
}


}


