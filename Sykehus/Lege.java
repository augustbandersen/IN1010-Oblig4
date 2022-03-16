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

    /*
    @Override
    public int compareTo(Lege lege){
        char[] lege1 = legeNavn.toLowerCase().toCharArray(); //Liste med bokstaver fra navn paa lege 1
        char[] lege2 = lege.hentLegeNavn().toLowerCase().toCharArray(); //Liste med bokstaver fra navn paa lege 2

        for (int i=0; i < lege1.length; i++){
            int bokstavIndeks = 0;
            if (lege1[bokstavIndeks] == lege2[bokstavIndeks]){
            bokstavIndeks++;
            } else if (lege1[bokstavIndeks] > lege2[bokstavIndeks]){

            }

        }
        return 1;
    }
    */

    @Override
    public int compareTo(Lege lege){
       return 0;
    }

    public IndeksertListe<Resept> hentUtskrevneResepter(){
        return utskrevneResepter;
    }

    HvitResept skrivHvitResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
        if (legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this, legemiddel);
        }

        HvitResept hvitResept = new HvitResept(legemiddel, this, pasient.hentId(), reit);
        utskrevneResepter.leggTil(hvitResept);
        return hvitResept;
    }

    MilResept skrivMilResept (Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift{
        if (legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this, legemiddel);
        }

        MilResept milResept = new MilResept(legemiddel, this, pasient.hentId());
        utskrevneResepter.leggTil(milResept);
        return milResept;
    }

    PResept skrivPResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{  
        if (legemiddel instanceof Narkotisk){
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
        
        BlaaResept blaaResept = new BlaaResept(legemiddel, this, pasient.hentId(), reit);
        utskrevneResepter.leggTil(blaaResept);
        return blaaResept;
    }
}