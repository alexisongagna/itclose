package com.itclose.itclose.model;

import org.apache.solr.client.solrj.beans.Field;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "RESTAURANT")
public class Restaurant {

    @Id
    @GeneratedValue
    private int id;
    private String nom ;
    private String pays ;
    private String ville ;
    private String quartier ;
    private String rue ;
    private int anneeCreation ;
    private int nbEtoile;
    private String typesPlats ;
    private String telephone;
    private String email ;
    private String siteWeb ;

    public Restaurant(String nom, String pays, String ville, String quartier, String rue, int anneeCreation, int nbEtoile, List<String> plats, String telephone, String email, String siteWeb) {
        this.nom = nom;
        this.pays = pays;
        this.ville = ville;
        this.quartier = quartier;
        this.rue = rue;
        this.anneeCreation = anneeCreation;
        this.nbEtoile = nbEtoile;
        this.telephone = telephone;
        this.email = email;
        this.siteWeb = siteWeb;

        this.typesPlats ="";
        if (plats != null && plats.size()>1)
        {
            for (int i =0 ; i< plats.size(); i++)
                this.typesPlats = typesPlats+' '+plats.get(i);
        }
        typesPlats = typesPlats.trim();
    }

    public Restaurant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    @Field("nom")
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPays() {
        return pays;
    }

    @Field("pays")
    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    @Field("ville")
    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getQuartier() {
        return quartier;
    }

    @Field("quartier")
    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public String getRue() {
        return rue;
    }

    @Field("rue")
    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getAnneeCreation() {
        return anneeCreation;
    }

    @Field("anneecreation")
    public void setAnneeCreation(int anneeCreation) {
        this.anneeCreation = anneeCreation;
    }

    public int getNbEtoile() {
        return nbEtoile;
    }

    @Field("nbetoile")
    public void setNbEtoile(int nbEtoile) {
        this.nbEtoile = nbEtoile;
    }

    public String getTelephone() {
        return telephone;
    }

    @Field("telephone")
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    @Field("email")
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    @Field("siteweb")
    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public String getTypesPlats() {
        return typesPlats;
    }

    @Field("typesplats")
    public void setTypesPlats(String typesPlats) {
        this.typesPlats = typesPlats;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", pays='" + pays + '\'' +
                ", ville='" + ville + '\'' +
                ", quartier='" + quartier + '\'' +
                ", rue='" + rue + '\'' +
                ", anneeCreation=" + anneeCreation +
                ", nbEtoile=" + nbEtoile +
                ", typesPlats='" + typesPlats + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", siteWeb='" + siteWeb + '\'' +
                '}';
    }
}
