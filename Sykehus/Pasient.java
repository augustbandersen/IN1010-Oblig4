package Sykehus;

import Lenkeliste.IndeksertListe;
public class Pasient{
  private String navn;
  private String foedselsnr;
  static int antPasient = 1;
  int idPasient;
  IndeksertListe<Resept> reseptListe = new IndeksertListe<>();

  public Pasient(String navn, String foedselsnr) {
    this.foedselsnr = foedselsnr;
    this.navn = navn;
    idPasient = antPasient;
    antPasient++;
  }
  // Legger  resept til i  stabelen.
  public void leggTilResept(Resept resept) {
    reseptListe.leggTil(resept);
  }
  public IndeksertListe<Resept> hentReseptListe() {return reseptListe;}
  public String hentNavn() {return navn;}
  public String hentFoedselsnr() {return foedselsnr;}
  public int hentId() {return idPasient;}

  @Override
  public String toString() {
    return navn +","+foedselsnr;
  }
}