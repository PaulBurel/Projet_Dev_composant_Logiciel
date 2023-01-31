package com.example.my_movie.models;


import io.swagger.annotations.ApiModelProperty;

import java.util.Date;



public class Film {
    @ApiModelProperty(value = "Titre du film", example = "Le seigneur des anneaux")
    String titre;
    @ApiModelProperty(value = "Nom du réalisateur", example = "Peter Jackson")
    String realisateur;
    @ApiModelProperty(value = "Nom de l'acteur principal", example = "Elijah Wood")
    Acteur acteurP;
    @ApiModelProperty(value = "Date de sortie du film", example = "2001-12-19")
    String date;

    public Film(String titre, String realisateur, Acteur acteurP, String date) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.acteurP = acteurP;
        this.date = date;
    }

    public String getTitre(){
        return titre;
    }

    public void setTitre(String titre){
        this.titre = titre;
    }

    public String getRealisateur(){
        return realisateur;
    }

    public void setRealisateur(String realisateur){
        this.realisateur = realisateur;
    }

    public Acteur getActeurP(){
        return acteurP;
    }

    public void setActeurP(Acteur acteurP){
        this.acteurP = acteurP;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }
}
