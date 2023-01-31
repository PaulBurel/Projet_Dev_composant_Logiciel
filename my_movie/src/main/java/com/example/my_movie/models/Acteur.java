package com.example.my_movie.models;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class Acteur {
    @ApiModelProperty(value = "Nom de l'acteur", example = "Elijah")
    public String nom;
    @ApiModelProperty(value = "Prénom de l'acteur", example = "Wood")
    public String prenom;
    @ApiModelProperty(value = "Date de naissance de l'acteur", example = "1981-01-28")
    public String dateNaissance;
    @ApiModelProperty(value = "Liste des films dans lesquels l'acteur a joué")
    List<Film> films;

    public Acteur(String nom, String prenom, String dateNaissance, List<Film> films) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.films = films;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
