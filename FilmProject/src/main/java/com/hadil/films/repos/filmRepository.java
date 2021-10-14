package com.hadil.films.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hadil.films.entities.Film;
import com.hadil.films.entities.Genre;

public interface filmRepository extends JpaRepository<Film, Long>{
	public List<Film> findByNomFilm(String nom);
	 List<Film> findByNomFilmContains(String nom);
	 
	   @Query("select p from Film p where p.nomFilm like %:nom and p.prixTicket > :prix")
		List<Film> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
		
		 @Query("select p from Film p where p.genre = ?1")
		 List<Film> findByGenre (Genre genre);
		 
		 List<Film> findByGenreIdGen(long l);
		 List<Film> findByOrderByNomFilmAsc();
		 
		 @Query("select p from Film p order by p.nomFilm ASC, p.prixTicket DESC")
		 List<Film> trierFilmsNomsPrix ();

}
