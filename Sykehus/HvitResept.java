package Sykehus;
public class HvitResept extends Resept{
    
    //Konstruktor
    public HvitResept(Legemiddel legemiddel, Lege utrskivendeLege, int pasientId, int reit){
        super(legemiddel, utrskivendeLege, pasientId, reit);
    }

    @Override
    public String farge(){
        return "Hvit";
    }
    
    //Hvis HvitResept verken er MilResept eller PResept
    @Override
    public int prisAaBetale(){ 
        return legemiddel.hentPris();
    }

    @Override
    public String finereStreng(){
        return (legemiddel.hentId() + "," + utskrivendeLege.hentLegeNavn() + "," + pasientId + "," + "hvit" + "," + reit);
    }
}
