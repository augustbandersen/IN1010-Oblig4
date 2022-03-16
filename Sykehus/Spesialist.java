package Sykehus;
public class Spesialist extends Lege implements Godkjenningsfritak{
    String kontrollId;
    
    //Konstruktor
    public Spesialist(String navn, String kontrollId){
        super(navn);
        this.kontrollId = kontrollId;
    }

    public String hentKontrollId(){
        return kontrollId;
    }

    @Override
    public String toString(){
        return (super.toString() + ", kontrollId: " + kontrollId);
    }
}
