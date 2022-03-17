package Sykehus;
public class Vanlig extends Legemiddel{
    
    //Konstruktor
    public Vanlig(String navn, int pris, double virkestoff){
        super(navn, pris, virkestoff);
    }

    @Override
    public String toString(){
        return (super.toString() + ", Id: " + id);
    }
}
