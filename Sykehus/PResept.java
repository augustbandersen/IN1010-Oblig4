package Sykehus;
class PResept extends HvitResept{
    
    //Konstruktor
    public PResept(Legemiddel legemiddel, Lege utrskivendeLege, int pasientId, int reit){
        super(legemiddel, utrskivendeLege, pasientId, reit);
    }

    //Hvis prisen er over 108, trekker den fra 108 og returnerer prisen,
    //ellers (altså om prisen er under 108) returnerer den 0
    @Override
    public int prisAaBetale(){
        int pris = legemiddel.hentPris();

        if (pris>108){
            return pris-=108;
        } else {
            return 0;
        }
    }

    @Override
    public String finereStreng(){
        return ("reseptId" + "," + utskrivendeLege + "," + pasientId + "," + "p" + "," + reit);
    }
}
