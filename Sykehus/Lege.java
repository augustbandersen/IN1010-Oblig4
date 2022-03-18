package Sykehus;

import Lenkeliste.*;
public class Lege implements Comparable<Lege> {
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
        int sammenlikning = 0;
        int s1;
        int s2;

        for (int i = 0; i < legeNavn.length() && i < lege.hentLegeNavn().length(); i++){
            s1 = (int) legeNavn.toLowerCase().charAt(i);
            s2 = (int) lege.hentLegeNavn().toLowerCase().charAt(i);
            sammenlikning = s1-s2;

            if (sammenlikning != 0){
                return sammenlikning;
            }
        }
        if (legeNavn.length() > lege.hentLegeNavn().length()){
            return 1;
        }
        else if (legeNavn.length() < lege.hentLegeNavn().length()){
            return -1;
        }
        return 0;
    
    }

    public IndeksertListe<Resept> hentUtskrevneResepter(){
        return utskrevneResepter;
    }

    public HvitResept skrivHvitResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
        if (legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this, legemiddel);
        }

        HvitResept hvitResept = new HvitResept(legemiddel, this, pasient.hentId(), reit);
        utskrevneResepter.leggTil(hvitResept);
        return hvitResept;
    }

    public MilResept skrivMilResept (Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift{
        if (legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this, legemiddel);
        }

        MilResept milResept = new MilResept(legemiddel, this, pasient.hentId());
        utskrevneResepter.leggTil(milResept);
        return milResept;
    }

    public PResept skrivPResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{  
        if (legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this, legemiddel);
        }

        PResept pResept = new PResept(legemiddel, this, pasient.hentId(), reit);
        utskrevneResepter.leggTil(pResept);
        return pResept;
    }

    public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{  
        if (!(this instanceof Spesialist) && (legemiddel instanceof Narkotisk)){
            throw new UlovligUtskrift(this, legemiddel);
        }
        
        BlaaResept blaaResept = new BlaaResept(legemiddel, this, pasient.hentId(), reit);
        utskrevneResepter.leggTil(blaaResept);
        return blaaResept;
    }

    public String finereStreng(){
        return (legeNavn + ", 0");
    }
}