package Sykehus;
public abstract class Resept {
    private int reseptId;
    private static int antall;
    protected Legemiddel legemiddel;
    protected Lege utskrivendeLege; 
    protected int pasientId;
    protected int reit;

    //Konstruktor
    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasientId;
        this.reit = reit;
        antall++;
        reseptId = antall;
    }
    
    public int hentId(){
        return reseptId;
    }

    public Legemiddel hentLegemiddel(){
        return legemiddel;
    }

    public Lege hentLege(){
        return utskrivendeLege;
    }

    public int hentPasientId(){
        return pasientId;
    }

    public int hentReit(){
        return reit;
    }

    //Hvis reit er storre enn 0, trekker den fra 1 og returnerer true, ellers returnerer den false
    public boolean bruk(){
        if (reit>0) {
            reit--;
            return true;
        } else {
            return false;
        } 
    }

    abstract public String farge();
    
    abstract public int prisAaBetale();

    @Override
    public String toString() {
        return("--------------------\n" + "Legemiddel: " + legemiddel.hentNavn() + "\nLege: " + utskrivendeLege.hentLegeNavn() + "\nPasientId: " + pasientId + "\nReit: " + reit);
      }

    public String finereStreng(){
        return (reseptId + "," + utskrivendeLege + "," + pasientId + "," + "type" + "," + reit);
    }
}
