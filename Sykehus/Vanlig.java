package Sykehus;
class Vanlig extends Legemiddel{
    private static int antall;
    private int vanligId;
    
    //Konstruktor
    public Vanlig(String navn, int pris, double virkestoff){
        super(navn, pris, virkestoff);
        antall++;
        vanligId = antall;
    }

    public int hentId(){
        return vanligId;
    }

    @Override
    public String toString(){
        return (super.toString() + ", Id: " + vanligId);
    }
}
