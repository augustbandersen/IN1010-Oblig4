package Sykehus;
abstract class Legemiddel {
    protected String navn;
    protected int pris;
    protected double virkestoff;

    //Konstruktor
    public Legemiddel(String navn, int pris, double virkestoff){
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
    }

    public abstract int hentId();

    public String hentNavn(){
        return navn;
    }

    public int hentPris(){
        return pris;
    }

    public double hentVirkestoff(){
        return virkestoff;
    }

    public void settNyPris(int nyPris){
        pris = nyPris;
    }

    public String toString() {
        return("Navn: " + navn + ", Pris: " + pris + ", Virkestoff: " + virkestoff);
      }
}
