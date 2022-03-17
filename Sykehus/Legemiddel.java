package Sykehus;
public abstract class Legemiddel {
    protected String navn;
    protected int pris;
    protected double virkestoff;
    protected static int idCounter = 0;
    protected int id;

    //Konstruktor
    public Legemiddel(String navn, int pris, double virkestoff){
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        Legemiddel.idCounter ++;
        this.id = Legemiddel.idCounter;
        
    }

    public int hentId(){
        return id;
    }

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
