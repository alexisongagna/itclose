package com.itclose.itclose.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.solr.client.solrj.beans.Field;

@Entity
@Table(name = "CENTRE_HOSPITALIER")
public class CentreHospitalier {

    @Id
    @GeneratedValue
    private int id;

    private String nom ;
    private String creation ;
    private String pays ;
    private String ville ;
    private String quartier ;
    private String adresse ;
    private String typeCentreHospitalier ;
    private String specialites ;
    private String telephone ;
    private String email ;
    private String boitePostale ;

    public CentreHospitalier()
    {}

    public CentreHospitalier(String nom, String creation, String pays, String ville, String quartier, String adresse, String typeCentreHospitalier, List<String> spec, String telephone, String email, String boitePostale) {
        this.nom = nom;
        this.creation = creation;
        this.pays = pays;
        this.ville = ville;
        this.quartier = quartier;
        this.adresse = adresse;
        this.typeCentreHospitalier = typeCentreHospitalier;
        this.telephone = telephone;
        this.email = email;
        this.boitePostale = boitePostale;

        this.specialites ="";
        if (spec != null && spec.size()>1)
        {
            for (int i =0 ; i< spec.size(); i++)
                this.specialites = specialites+' '+spec.get(i);
        }
        specialites = specialites.trim();
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

    public String getCreation() {
        return creation;
    }

    @Field("creation")
    public void setCreation(String creation) {
        this.creation = creation;
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

    public String getAdresse() {
        return adresse;
    }

    @Field("adresse")
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTypeCentreHospitalier() {
        return typeCentreHospitalier;
    }

    @Field("typeCentreHospitalier")
    public void setTypeCentreHospitalier(String typeCentreHospitalier) {
        this.typeCentreHospitalier = typeCentreHospitalier;
    }

    public String getSpecialites() {
        return specialites;
    }

    @Field("specialites")
    public void setSpecialites(String spec) {
        this.specialites = spec;
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

    public String getBoitePostale() {
        return boitePostale;
    }


    @Field("boitePostale")
    public void setBoitePostale(String boitePostale) {
        this.boitePostale = boitePostale;
    }

    @Override
    public String toString() {
        return "CentreHospitalier{" +
                "nom='" + nom + '\'' +
                ", creation='" + creation + '\'' +
                ", pays='" + pays + '\'' +
                ", ville='" + ville + '\'' +
                ", quartier='" + quartier + '\'' +
                ", adresse='" + adresse + '\'' +
                ", typeCentreHospitalier='" + typeCentreHospitalier + '\'' +
                ", specialites=" + specialites +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", boitePostale='" + boitePostale + '\'' +
                '}';
    }
}
