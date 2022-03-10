class Lege {
    String legeNavn;
    //Konstruktor
    public Lege(String legeNavn){
        this.legeNavn = legeNavn;
    }

    public String hentLegeNavn(){
        return legeNavn;
    }

    @Override
    public String toString(){
        return ("Legens navn: " + legeNavn);
    }
}
