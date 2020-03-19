package com.itclose.itclose.model;

import org.apache.solr.client.solrj.beans.Field;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

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
    private String dateCreation ;
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
    private String nbEtoile ;
    private String typesPlats ;

    //Fields for Entreprise
    private String secteurActivite ;
    private String statutJuridique ;
    private String regimeFiscal ;

    //Fields for Assurance
    private String assureur ;
    private String prime ;
    private String valeurPrime ;
    private String dureePrime;

    //Fields for TransporteurTerrestre
    private String typeVehicule ;
    private String agentRavitoCarburant ;

    //Fields for TransporteurAerien
    private String typeAvion ;
    private String nbPilotes ;

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

    @Field("categoriereferentiel")
    public void setCategorieReferentiel(String categorieReferentiel) {
        this.categorieReferentiel = categorieReferentiel;
    }

    public String getNomStructure() {
        return nomStructure;
    }

    @Field("nomstructure")
    public void setNomStructure(String nomStructure) {
        this.nomStructure = nomStructure;
    }

    public String getNomPrenomResponsable() {
        return nomPrenomResponsable;
    }

    @Field("nomprenomresponsable")
    public void setNomPrenomResponsable(String nomPrenomResponsable) {
        this.nomPrenomResponsable = nomPrenomResponsable;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    @Field("datecreation")
    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
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

    public String getRue() {
        return rue;
    }

    @Field("rue")
    public void setRue(String rue) {
        this.rue = rue;
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

    public String getBoitePostale() {
        return boitePostale;
    }

    @Field("boitepostale")
    public void setBoitePostale(String boitePostale) {
        this.boitePostale = boitePostale;
    }

    public String getTypeCentreHospitalier() {
        return typeCentreHospitalier;
    }

    @Field("typecentrehospitalier")
    public void setTypeCentreHospitalier(String typeCentreHospitalier) {
        this.typeCentreHospitalier = typeCentreHospitalier;
    }

    public String getSpecialites() {
        return specialites;
    }

    @Field("specialites")
    public void setSpecialites(String specialites) {
        this.specialites = specialites;
    }

    public String getNbEtoile() {
        return nbEtoile;
    }

    @Field("nbetoile")
    public void setNbEtoile(String nbEtoile) {
        this.nbEtoile = nbEtoile;
    }

    public String getTypesPlats() {
        return typesPlats;
    }

    @Field("typesplats")
    public void setTypesPlats(String typesPlats) {
        this.typesPlats = typesPlats;
    }


    public String getSecteurActivite() {
        return secteurActivite;
    }

    @Field("secteuractivite")
    public void setSecteurActivite(String secteurActivite) {
        this.secteurActivite = secteurActivite;
    }

    public String getStatutJuridique() {
        return statutJuridique;
    }

    @Field("statutjuridique")
    public void setStatutJuridique(String statutJuridique) {
        this.statutJuridique = statutJuridique;
    }

    public String getRegimeFiscal() {
        return regimeFiscal;
    }

    @Field("regimefiscal")
    public void setRegimeFiscal(String regimeFiscal) {
        this.regimeFiscal = regimeFiscal;
    }

    public String getAssureur() {
        return assureur;
    }

    @Field("assureur")
    public void setAssureur(String assureur) {
        this.assureur = assureur;
    }

    public String getPrime() {
        return prime;
    }

    @Field("prime")
    public void setPrime(String prime) {
        this.prime = prime;
    }

    public String getValeurPrime() {
        return valeurPrime;
    }

    @Field("valeurprime")
    public void setValeurPrime(String valeurPrime) {
        this.valeurPrime = valeurPrime;
    }

    public String getDureePrime() {
        return dureePrime;
    }

    @Field("dureeprime")
    public void setDureePrime(String dureePrime) {
        this.dureePrime = dureePrime;
    }

    public String getTypeVehicule() {
        return typeVehicule;
    }

    @Field("typevehicule")
    public void setTypeVehicule(String typeVehicule) {
        this.typeVehicule = typeVehicule;
    }

    public String getAgentRavitoCarburant() {
        return agentRavitoCarburant;
    }

    @Field("agentravitocarburant")
    public void setAgentRavitoCarburant(String agentRavitoCarburant) {
        this.agentRavitoCarburant = agentRavitoCarburant;
    }

    public String getTypeAvion() {
        return typeAvion;
    }

    @Field("typeavion")
    public void setTypeAvion(String typeAvion) {
        this.typeAvion = typeAvion;
    }

    public String getNbPilotes() {
        return nbPilotes;
    }

    @Field("nbpilotes")
    public void setNbPilotes(String nbPilotes) {
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
