package com.itclose.itclose.model;

import org.apache.solr.client.solrj.beans.Field;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ENTREPRISE")
public class Entreprise {
    @Id
    @GeneratedValue
    private int id;
    private String pays ;
    private String secteurActivite ;
    private String nom ;
    private int anneeCreation ;
    private String statutJuridique ;
    private String regimeFiscal ;
    private String siteWeb ;

    public Entreprise(){}

    public Entreprise(String pays, String secteurActivite, String nom, int anneeCreation, String statutJuridique, String regimeFiscal, String siteWeb) {

        this.pays = pays;
        this.secteurActivite = secteurActivite;
        this.nom = nom;
        this.anneeCreation = anneeCreation;
        this.statutJuridique = statutJuridique;
        this.regimeFiscal = regimeFiscal;
        this.siteWeb = siteWeb;
    }

    public int getId() {
        return id;
    }

    @Field("id")
    public void setId(int id) {
        this.id = id;
    }

    public String getPays() {
        return pays;
    }

    @Field("pays")
    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getSecteurActivite() {
        return secteurActivite;
    }

    @Field("secteur_activite")
    public void setSecteurActivite(String secteurActivite) {
        this.secteurActivite = secteurActivite;
    }

    public String getNom() {
        return nom;
    }

    @Field("nom")
    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAnneeCreation() {
        return anneeCreation;
    }

    @Field("annee_creation")
    public void setAnneeCreation(int anneeCreation) {
        this.anneeCreation = anneeCreation;
    }

    public String getStatutJuridique() {
        return statutJuridique;
    }

    @Field("statut_juridique")
    public void setStatutJuridique(String statutJuridique) {
        this.statutJuridique = statutJuridique;
    }

    public String getRegimeFiscal() {
        return regimeFiscal;
    }

    @Field("regime_fiscal")
    public void setRegimeFiscal(String regimeFiscal) {
        this.regimeFiscal = regimeFiscal;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    @Field("site_web")
    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }
}
