package com.example.my_movie.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.my_movie.models.Acteur;
import com.example.my_movie.models.Film;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "MyMovieRestController", description = "REST Api")
@RestController
public class MyMovieRestController {
    List<Film> films = new ArrayList<Film>();
    List<Acteur> acteurs = new ArrayList<Acteur>();
    {
        acteurs.add(new Acteur("Elijah", "Wood", "1981-01-28", null));
        acteurs.add(new Acteur("Viggo", "Mortensen", "1958-10-20", null));
        acteurs.add(new Acteur("Ian", "McKellen", "1939-05-25", null));
        films.add(new Film("Le seigneur des anneaux", "Peter Jackson", acteurs.get(0), "2001-12-19"));
        films.add(new Film("Le seigneur des anneaux 2", "Peter Jackson", acteurs.get(0), "2002-12-19"));
        films.add(new Film("Le seigneur des anneaux 3", "Peter Jackson", acteurs.get(0), "2003-12-19"));
    }

    @ApiOperation(value = "Get list of Acteurs in the system", response = Iterable.class, tags = "getActeurs")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "not authorized"),
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    @RequestMapping(value = "/getActeurs")
    public List<Acteur> getActeurs() {
        return acteurs;
    }

    @ApiOperation(value = "Get list of Acteurs by nom in the system", response = Iterable.class, tags = "getActeur")
    @RequestMapping(value = "/getActeur/{nom}")
    public Acteur getActeur(@PathVariable(value = "nom") String nom) {
        for (Acteur acteur : acteurs) {
            if (acteur.getNom().equals(nom)) {
                return acteur;
            }
        }
        return null;
    }

    @ApiOperation(value = "Get list of Acteurs by film in the system", response = Iterable.class, tags = "getActeurByFilm")
    @RequestMapping(value = "/getActeurByFilm/{film}")
    public List<Acteur> getActeurByFilm(@PathVariable(value = "film") Film film) {
        List<Acteur> acteursByFilm = new ArrayList<Acteur>();
        for (Acteur acteur : acteurs) {
            if (acteur.getFilms().contains(film)) {
                acteursByFilm.add(acteur);
            }
        }
        return acteursByFilm;
    }

    @ApiOperation(value = "Get list of Films in the system", response = Iterable.class, tags = "getFilms")
    @RequestMapping(value = "/getFilms")
    public List<Film> getFilms() {
        return films;
    }


    @ApiOperation(value = "Get list of Films by titre in the system", response = Iterable.class, tags = "getFilm")
    @RequestMapping(value = "/getFilm/{titre}")
    public Film getFilm(@PathVariable(value = "titre") String titre) {
        for (Film film : films) {
            if (film.getTitre().equals(titre)) {
                return film;
            }
        }
        return null;
    }

    @ApiOperation(value = "Get list of Films by year in the system", response = Iterable.class, tags = "getFilmByYear")
    @RequestMapping(value = "/getFilmByYear/{year}")
    public List<Film> getFilmByYear(@PathVariable(value = "year") String year) {
        List<Film> filmsByYear = new ArrayList<Film>();
        for (Film film : films) {
            if (film.getDate().equals(year)) {
                filmsByYear.add(film);
            }
        }
        return filmsByYear;
    }

}
