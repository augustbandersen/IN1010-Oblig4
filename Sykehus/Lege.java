package Sykehus;

import Lenkeliste.*;
class Lege implements Comparable<Lege> {
    String legeNavn;
    IndeksertListe<Resept> utskrevneResepter = new IndeksertListe<>();

    //Konstruktor
    public Lege(String legeNavn){
        this.legeNavn = legeNavn;
    }

    public String hentLegeNavn(){
        return legeNavn;
    }

    @Override
    public String toString(){
        return ("Legens navn: " + legeNavn);
    }
    
    @Override
    public int compareTo(Lege lege){
        return legeNavn.toLowerCase().compareTo(lege.hentLegeNavn().toLowerCase());
    }

    public IndeksertListe<Resept> hentUtskrevneResepter(){
        return utskrevneResepter;
    }

    HvitResept skrHvitResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{}

    MilResept skrivMilResept (Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift{}

    PResept skrivPResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{}

    BlaaResept skrivBlaaResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{}
}
