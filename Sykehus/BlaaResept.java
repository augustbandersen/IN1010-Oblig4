package Sykehus;
public class BlaaResept extends Resept{
    
    //Konstruktor
    public BlaaResept(Legemiddel legemiddel, Lege utrskivendeLege, int pasientId, int reit){
        super(legemiddel, utrskivendeLege, pasientId, reit);
    }

    @Override
    public String farge(){
        return "Blaa";
    }

    //Returnerer 1/4 av prisen, rundet opp til naermeste heltall
    @Override
    public int prisAaBetale(){ 
        int pris = legemiddel.hentPris();
        pris = Math.round(pris*0.25f); //runder opp til naermest int
        return pris;
    }

    @Override
    public String finereStreng(){
        return (legemiddel.hentId() + "," + utskrivendeLege.hentLegeNavn() + "," + pasientId + "," + "blaa" + "," + reit);
    }
}
