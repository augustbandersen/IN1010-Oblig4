package Sykehus;
public class Narkotisk extends Legemiddel{
    private int styrke;
    private static int antall;
    private int narkotiskId;

    //Konstruktor
    public Narkotisk(String navn, int pris, double virkestoff, int styrke){
        super(navn, pris, virkestoff);
        this.styrke = styrke;
        antall++;
        narkotiskId = antall;
    }

    public int hentNarkotiskStyrke(){
        return styrke;
    }

    public int hentId(){
        return narkotiskId;
    }

    @Override
    public String toString(){
        return (super.toString() + ", Narkotisk styrke: " + styrke + " Id: " + narkotiskId);
    }
}
