class Vanedannende extends Legemiddel{
    private int styrke;
    private static int antall;
    private int vanedannendeId;

    //Konstruktor
    public Vanedannende(String navn, int pris, double virkestoff, int styrke){
        super(navn, pris, virkestoff);
        this.styrke = styrke;
        antall++;
        vanedannendeId = antall;
    } 
    
    public int hentVanedannendeStyrke(){
        return styrke;
    }
    
    public int hentId(){
        return vanedannendeId;
    }

    @Override
    public String toString(){
        return (super.toString() + ", Vanedannende styrke: " + styrke + ", Id: " + vanedannendeId);
    }
}
