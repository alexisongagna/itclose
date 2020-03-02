package com.itclose.itclose.model;

import org.apache.solr.client.solrj.beans.Field;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "REF_DATA")
public class RefData {

    @Id
    @GeneratedValue
    private int id;

    //Common fields
    private String categorieReferentiel ;
    private String nomStructure ;
    private String nomPrenomResponsable ;
    private Date dateCreation ;
    private String pays ;
    private String ville ;
    private String quartier ;
    private String adresse ;
    private String rue ;
    private String telephone ;
    private String email ;
    private String siteWeb ;
    private String boitePostale ;

    //Fields for CentreHospitaliers
    private String typeCentreHospitalier ;
    private String specialites ;

    //Common Fields for Restaurant and Hotel
    private int nbEtoile ;
    private String typesPlats ;

    //Fields for Entreprise
    private String secteurActivite ;
    private String statutJuridique ;
    private String regimeFiscal ;

    //Fields for Assurance
    private String assureur ;
    private float prime ;
    private float valeurPrime ;
    private int dureePrime;

    //Fields for TransporteurTerrestre
    private String typeVehicule ;
    private String agentRavitoCarburant ;

    //Fields for TransporteurAerien
    private String typeAvion ;
    private int nbPilotes ;

    //default constructor
    public RefData(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategorieReferentiel() {
        return categorieReferentiel;
    }

    public void setCategorieReferentiel(String categorieReferentiel) {
        this.categorieReferentiel = categorieReferentiel;
    }

    public String getNomStructure() {
        return nomStructure;
    }

    public void setNomStructure(String nomStructure) {
        this.nomStructure = nomStructure;
    }

    public String getNomPrenomResponsable() {
        return nomPrenomResponsable;
    }

    public void setNomPrenomResponsable(String nomPrenomResponsable) {
        this.nomPrenomResponsable = nomPrenomResponsable;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public String getBoitePostale() {
        return boitePostale;
    }

    public void setBoitePostale(String boitePostale) {
        this.boitePostale = boitePostale;
    }

    public String getTypeCentreHospitalier() {
        return typeCentreHospitalier;
    }

    public void setTypeCentreHospitalier(String typeCentreHospitalier) {
        this.typeCentreHospitalier = typeCentreHospitalier;
    }

    public String getSpecialites() {
        return specialites;
    }

    public void setSpecialites(String specialites) {
        this.specialites = specialites;
    }

    public int getNbEtoile() {
        return nbEtoile;
    }

    public void setNbEtoile(int nbEtoile) {
        this.nbEtoile = nbEtoile;
    }

    public String getTypesPlats() {
        return typesPlats;
    }

    public void setTypesPlats(String typesPlats) {
        this.typesPlats = typesPlats;
    }


    public String getSecteurActivite() {
        return secteurActivite;
    }

    public void setSecteurActivite(String secteurActivite) {
        this.secteurActivite = secteurActivite;
    }

    public String getStatutJuridique() {
        return statutJuridique;
    }

    public void setStatutJuridique(String statutJuridique) {
        this.statutJuridique = statutJuridique;
    }

    public String getRegimeFiscal() {
        return regimeFiscal;
    }

    public void setRegimeFiscal(String regimeFiscal) {
        this.regimeFiscal = regimeFiscal;
    }

    public String getAssureur() {
        return assureur;
    }

    public void setAssureur(String assureur) {
        this.assureur = assureur;
    }

    public float getPrime() {
        return prime;
    }

    public void setPrime(float prime) {
        this.prime = prime;
    }

    public float getValeurPrime() {
        return valeurPrime;
    }

    public void setValeurPrime(float valeurPrime) {
        this.valeurPrime = valeurPrime;
    }

    public int getDureePrime() {
        return dureePrime;
    }

    public void setDureePrime(int dureePrime) {
        this.dureePrime = dureePrime;
    }

    public String getTypeVehicule() {
        return typeVehicule;
    }

    public void setTypeVehicule(String typeVehicule) {
        this.typeVehicule = typeVehicule;
    }

    public String getAgentRavitoCarburant() {
        return agentRavitoCarburant;
    }

    public void setAgentRavitoCarburant(String agentRavitoCarburant) {
        this.agentRavitoCarburant = agentRavitoCarburant;
    }

    public String getTypeAvion() {
        return typeAvion;
    }

    public void setTypeAvion(String typeAvion) {
        this.typeAvion = typeAvion;
    }

    public int getNbPilotes() {
        return nbPilotes;
    }

    public void setNbPilotes(int nbPilotes) {
        this.nbPilotes = nbPilotes;
    }

    @Override
    public String toString() {
        return "RefData{" +
                "id=" + id +
                ", categorieReferentiel='" + categorieReferentiel + '\'' +
                ", nomStructure='" + nomStructure + '\'' +
                ", nomPrenomResponsable='" + nomPrenomResponsable + '\'' +
                ", dateCreation=" + dateCreation +
                ", pays='" + pays + '\'' +
                ", ville='" + ville + '\'' +
                ", quartier='" + quartier + '\'' +
                ", adresse='" + adresse + '\'' +
                ", rue='" + rue + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", siteWeb='" + siteWeb + '\'' +
                ", boitePostale='" + boitePostale + '\'' +
                ", typeCentreHospitalier='" + typeCentreHospitalier + '\'' +
                ", specialites='" + specialites + '\'' +
                ", nbEtoile=" + nbEtoile +
                ", typesPlats='" + typesPlats + '\'' +
                ", secteurActivite='" + secteurActivite + '\'' +
                ", statutJuridique='" + statutJuridique + '\'' +
                ", regimeFiscal='" + regimeFiscal + '\'' +
                ", assureur='" + assureur + '\'' +
                ", prime=" + prime +
                ", valeurPrime=" + valeurPrime +
                ", dureePrime=" + dureePrime +
                ", typeVehicule='" + typeVehicule + '\'' +
                ", agentRavitoCarburant='" + agentRavitoCarburant + '\'' +
                ", typeAvion='" + typeAvion + '\'' +
                ", nbPilotes='" + nbPilotes + '\'' +
                '}';
    }
}
