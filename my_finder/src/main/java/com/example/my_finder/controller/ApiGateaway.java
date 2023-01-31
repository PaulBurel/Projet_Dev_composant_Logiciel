package com.example.my_finder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ApiGateaway {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/getActeur/{nom}", method = RequestMethod.GET)
    public String getStudent(@PathVariable String nom) {
        String response = restTemplate.getForObject("http://my_movie/getActeur/{nom}", String.class, nom);
        return response;
    }

    @RequestMapping(value = "/getFilm/{nom}", method = RequestMethod.GET)
    public String getFilm(@PathVariable String nom) {
        String response = restTemplate.getForObject("http://my_movie/getFilm/{nom}", String.class, nom);
        return response;
    }

    @RequestMapping(value = "/getFilms", method = RequestMethod.GET)
    public String getFilms() {
        String response = restTemplate.getForObject("http://my_movie/getFilms", String.class);
        return response;
    }

    @RequestMapping(value = "/getActeurs", method = RequestMethod.GET)
    public String getActeurs() {
        String response = restTemplate.getForObject("http://my_movie/getActeurs", String.class);
        return response;
    }

    @RequestMapping(value = "/getFilmByYear/{year}", method = RequestMethod.GET)
    public String getFilmByYear(@PathVariable String year) {
        String response = restTemplate.getForObject("http://my_movie/getFilmByYear/{year}", String.class, year);
        return response;
    }

    @RequestMapping(value = "/getFilm/{titre}", method = RequestMethod.GET)
    public String getFilmByTitre(@PathVariable String titre) {
        String response = restTemplate.getForObject("http://my_movie/getFilm/{titre}", String.class, titre);
        return response;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
