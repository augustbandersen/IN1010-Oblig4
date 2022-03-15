import Lenkeliste.*;

class Pasient {
  private String navn;
  private String foedselsnr;
  static int antPasient = 0;
  int idPasient;
  Stabel<Resept> reseptStabel = new Stabel<Resept>();

  public Pasient(String navn, String foedselsnr) {
    this.foedselsnr = foedselsnr;
    this.navn = navn;
    idPasient = antPasient;
    antPasient++;
  }
  // Legger  resept til i  stabelen.
  public void leggTilResept(Resept resept) {
    reseptStabel.leggPaa(resept);
  }
  public Stabel<Resept> hentStabel() {return reseptStabel;}
  public String hentNavn() {return navn;}
  public String hentFoedselsnr() {return foedselsnr;}
  public int hentId() {return idPasient;}

  @Override
  public String toString() {
    return navn +","+foedselsnr;
  }
}