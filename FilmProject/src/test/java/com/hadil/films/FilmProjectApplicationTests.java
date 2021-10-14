package com.hadil.films;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hadil.films.entities.Film;
import com.hadil.films.entities.Genre;
import com.hadil.films.repos.filmRepository;

@SpringBootTest
class FilmProjectApplicationTests {
	@Autowired
	private filmRepository filmRepository;
	
	@Test
	public void testCreateFilm() {
		Film film = new Film("Iron man", 20000.0, new Date());

		filmRepository.save(film);
	}
	
	@Test
	public void testFindByNomFilm() {
		List<Film> films = filmRepository.findByNomFilm("iron");
		for (Film p : films) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByNomFilmContains() {
		List<Film> films = filmRepository.findByNomFilmContains("Iron");
		for (Film p : films) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testfindByNomPrix() {
		List<Film> prods = filmRepository.findByNomPrix("Iron man", 1000.0);
		for (Film p : prods) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testfindByGenre()
	{
		Genre gen = new Genre();
		gen.setIdGen(1L);
		List<Film> films = filmRepository.findByGenre(gen);
		for (Film f : films)
			{
				System.out.println(f);
			}
	}
	@Test
	public void findByGenreIdGen()
		{
			List<Film> films = filmRepository.findByGenreIdGen(1L);
		for (Film p : films)
			{
			System.out.println(p);
			}

	}
	
	@Test
	public void testfindByOrderByNomFilmAsc()
	{
	List<Film> films = filmRepository.findByOrderByNomFilmAsc();
	for (Film p : films)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testTrierFilmsNomsPrix()
	{
	List<Film> films = filmRepository.trierFilmsNomsPrix();
	for (Film p : films)
	{
	System.out.println(p);
	}
	}
}
