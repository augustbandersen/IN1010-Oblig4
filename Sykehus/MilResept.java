package Sykehus;
public class MilResept extends HvitResept{

    //Konstruktor uten parameteren reit / den er satt til 3
    public MilResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId){
        super(legemiddel, utskrivendeLege, pasientId, 3);
    }

    //100% rabatt blir 0kr i pris
    @Override
    public int prisAaBetale(){
        return 0;
    }

    @Override
    public String finereStreng(){
        return (legemiddel.hentId() + "," + utskrivendeLege.hentLegeNavn() + "," + pasientId + "," + "militaer" + "," + reit);
    }
}
