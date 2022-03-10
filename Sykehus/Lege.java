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

    HvitResept skrHvitResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
        if (!(this instanceof Spesialist) && (legemiddel instanceof Narkotisk)){
            throw new UlovligUtskrift(this, legemiddel);
        }

        HvitResept hvitResept = new HvitResept(legemiddel, this, pasient.hentId(), reit);
        utskrevneResepter.leggTil(hvitResept);
        return hvitResept;
    }

    MilResept skrivMilResept (Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift{
        if (!(this instanceof Spesialist) && (legemiddel instanceof Narkotisk)){
            throw new UlovligUtskrift(this, legemiddel);
        }

        MilResept milResept = new MilResept(legemiddel, this, pasient.hentId());
        utskrevneResepter.leggTil(milResept);
        return milResept;
    }

    PResept skrivPResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{  
        if (!(this instanceof Spesialist) && (legemiddel instanceof Narkotisk)){
            throw new UlovligUtskrift(this, legemiddel);
        }

        PResept pResept = new PResept(legemiddel, this, pasient.hentId(), reit);
        utskrevneResepter.leggTil(pResept);
        return pResept;
    }

    BlaaResept skrivBlaaResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{  
        if (!(this instanceof Spesialist) && (legemiddel instanceof Narkotisk)){
            throw new UlovligUtskrift(this, legemiddel);
        }

        //Spesialister kan alltid skrive ut Narkotiske legemidler men bare på blaa resept.
        //(Skal fikse dette ^. Naa kan spesialist skrive ut Narkotiske legemidler paa alle resepter)

        BlaaResept blaaResept = new BlaaResept(legemiddel, this, pasient.hentId(), reit);
        utskrevneResepter.leggTil(blaaResept);
        return blaaResept;
    }
}
