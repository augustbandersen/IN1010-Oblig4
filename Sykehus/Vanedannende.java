package Sykehus;
public class Vanedannende extends Legemiddel{
    private int styrke;

    //Konstruktor
    public Vanedannende(String navn, int pris, double virkestoff, int styrke){
        super(navn, pris, virkestoff);
        this.styrke = styrke;
    } 
    
    public int hentVanedannendeStyrke(){
        return styrke;
    }


    @Override
    public String toString(){
        return (super.toString() + ", Vanedannende styrke: " + styrke + ", Id: " + id);
    }

    @Override
    public String finereStreng(){
        return (navn + "," + "Vanedannende" + "," + pris + "," + virkestoff + "," + styrke);
    }
}
