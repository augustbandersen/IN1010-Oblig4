package Sykehus;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Lenkeliste.*;
import java.io.FileWriter;

public class Legesystem { 
    private IndeksertListe<Pasient> pasientListe = new IndeksertListe<>();
    private IndeksertListe<Legemiddel> legemiddelListe = new IndeksertListe<>();
    private Prioritetskoe<Lege> legeListe = new Prioritetskoe<>();
    private IndeksertListe<Resept> reseptListe = new IndeksertListe<>();
    
    public void lesFraFil(File fil) throws Exception{//Samuel
        String type = "";
        try{
            Scanner scanner = new Scanner(fil);
            while(scanner.hasNextLine()){
                String[] linje = scanner.nextLine().split(",");

                if(linje[0].split("#").length > 1){
                    type = linje[0].split(" ")[1];
                    continue;
                }
                if(type.equalsIgnoreCase("Pasienter"))leggTilPasient(new Pasient(linje[0], linje[1]));

                if(type.equals("Legemidler")){
                    String navn = linje[0];
                    String legemiddeltype = linje[1];
                    int pris = Integer.parseInt(linje[2]);
                    Double virkestoff = Double.parseDouble(linje[3]);
                    if(legemiddeltype.equals("vanlig")){
                        Legemiddel legemiddel = new Vanlig(navn, pris, virkestoff);
                        leggTilLegemiddel(legemiddel);
                    }
                    if(legemiddeltype.equals("narkotisk")){
                        int styrke = Integer.parseInt(linje[4]);
                        Legemiddel legemiddel = new Narkotisk(navn, pris, virkestoff, styrke);
                        leggTilLegemiddel(legemiddel);
                    }
                    if(legemiddeltype.equals("vanedannende")){
                        int styrke = Integer.parseInt(linje[4]);
                        Legemiddel legemiddel = new Vanedannende(navn, pris, virkestoff, styrke);
                        leggTilLegemiddel(legemiddel);
                    }

                }
                if(type.equals("Leger")){
                    String navn = linje[0];
                    String kontrollid = linje[1];
                    Lege lege;

                    if(!kontrollid.equals("0")){
                        lege = new Spesialist(navn, kontrollid);
                    }
                    else{lege = new Lege(navn);}

                    leggTilLege(lege);
                }
                if(type.equals("Resepter")){
                    int legemiddelNummer = Integer.parseInt(linje[0]);
                    String legeNavn = linje[1];
                    int pasientId = Integer.parseInt(linje[2]);
                    String resepttype = linje[3];
                    Lege lege = null;
                    Legemiddel legemiddel = null;
                    Pasient pasient = null;
                    int reit = 1;
                    Resept resept = null;

                    for(Lege l : legeListe){
                        if(l.hentLegeNavn().equals(legeNavn)) lege = l;
                    }if(lege == null) throw new Exception("Ingen lege med riktig navn");

                    for(Legemiddel l : legemiddelListe){
                        if(l.hentId() == legemiddelNummer) legemiddel = l;
                    }if(legemiddel == null) throw new Exception("Ingen legemiddel med ritktig ID");

                    for(Pasient p :pasientListe){
                        if(p.hentId() == pasientId) pasient = p;
                    }if(pasient == null) throw new Exception("Ingen pasient med riktig ID");
                    
                    if(linje.length == 5) reit = Integer.parseInt(linje[4]);

                    if(resepttype.equals("hvit")){
                        resept = lege.skrivHvitResept(legemiddel, pasient, reit);
                    }
                    if(resepttype.equals("blaa")){
                        resept = lege.skrivBlaaResept(legemiddel, pasient, reit);
                    }
                    if(resepttype.equals("militaer")){
                        resept = lege.skrivMilResept(legemiddel, pasient);
                    }
                    if(resepttype.equals("p")){
                        resept = lege.skrivPResept(legemiddel, pasient, reit);
                    }
                    leggTilResept(resept);
                    pasient.leggTilResept(resept);
                }
            }
            scanner.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e);  
        }
        
    }

    public void oversikt(Scanner scanner){ // August
        //Oversikt over pasienter
        System.out.println(); //Ny linje
        System.out.println("Alle pasienter:");
        for (Pasient p : pasientListe) {
            System.out.println(p + ", Id: " + p.hentId());
        }

        //Oversikt over leger
        System.out.println(); // Ny linje
        System.out.println("Alle leger:");
        for (Lege l : legeListe) {
            if (l instanceof Spesialist){
                System.out.println(l + ", Spesialist");
            } else{
                System.out.println(l + ", vanlig");
            }
        }

        //Oversikt over legemidler
        System.out.println(); // Ny linje
        System.out.println("Alle legemidler:");
        for (Legemiddel l : legemiddelListe) {
            System.out.println(l);
        }

        //Oversikt over resepter
        System.out.println(); // Ny linje
        System.out.println("Alle resepter: ");
        for (Resept r : reseptListe) {
            System.out.println(r);
            
        }

        System.out.println();
        System.out.print("Trykk Enter for aa returnere til hovedmeny");
        scanner.nextLine();
        System.out.println();

    }

    public void leggTilLege(Lege lege){// Yuki
        legeListe.leggTil(lege);
    }

    public void leggTilPasient(Pasient pasient){// Yuki
        pasientListe.leggTil(pasient);   
    }

    public void leggTilLegemiddel(Legemiddel legemiddel){// Yuki
        legemiddelListe.leggTil(legemiddel);
    }

    public void leggTilResept(Resept resept){// Yuki
        reseptListe.leggTil(resept);
    }
    public void skrivStatistikk(Scanner scanner){// August
        //Antall utskrevene resepter paa vanedannende og narkotiske legemidler
        int antVane = 0; 
        int antNarko = 0;
        
        for (Lege l : legeListe){
            for (Resept r : l.hentUtskrevneResepter()){ 
                if (r.hentLegemiddel() instanceof Vanedannende){
                    antVane++;
                } else if (r.hentLegemiddel() instanceof Narkotisk){
                    antNarko++;
                }
            }
        }


        //Leger som har skrevet ut minst en resept paa narkotiske legemidler, og antallet resepter per lege
        IndeksertListe<String> narkoLeger = new IndeksertListe<>(); //Sortert i alfabetisk rekkefolge?
        for (Lege l : legeListe){
            int antNarkoResPerLege = 0;
            for (Resept r : l.hentUtskrevneResepter()){
                if (r.hentLegemiddel() instanceof Narkotisk){
                    antNarkoResPerLege++;
                }
            }

            if (antNarkoResPerLege != 0){
                String tmp = l.hentLegeNavn() + " | Antall respter utskrevet: " + antNarkoResPerLege;
                narkoLeger.leggTil(tmp);
            }
        }


        //Pasienter som har minst en gyldig resept paa narkotiske legemidler, og antallet resepter per pasient
        IndeksertListe<String> narkoPasienter = new IndeksertListe<>();
        for (Pasient p : pasientListe){
            int antNarkoResPerPasient = 0;
            for (Resept r : p.hentReseptListe()){
                if (r.hentLegemiddel() instanceof Narkotisk){
                    antNarkoResPerPasient++;
                }
            }
            if (antNarkoResPerPasient != 0){
                String tmp = p.hentNavn() + " | Antall respter: " + antNarkoResPerPasient;
                narkoPasienter.leggTil(tmp);
            }
        }


        System.out.println("Antall resepter for vanedannende legemidler: " + antVane);
        System.out.println("Antall resepter for narkotiske legemidler: " + antNarko);

        System.out.println();
        System.out.println("Leger som har skrevet ut resepter paa narkotiske legemidler:");
        for (String s : narkoLeger){
            System.out.println(s);
        }

        System.out.println();
        System.out.println("Pasienter som har gyldig resept paa narkotiske legemidler:");
        for (String s : narkoPasienter){
            System.out.println(s);
        }

        System.out.print("Trykk Enter for aa returnere til hovedmeny");
        scanner.nextLine();
    }

    public IndeksertListe<Pasient> hentPasientListe(){
        return this.pasientListe;
    }

    public void skrivTilFil(Scanner scanner){
        String filNavn = scanner.nextLine();
        try { //Lage ny fil
            File minFil = new File(filNavn);
            if (minFil.createNewFile()){
                System.out.println("Ny fil opprettet: " + minFil.getName());
            } else {
                System.out.println("Filen finnes fra for av.");
            }
            
        } catch (Exception e) {
            System.out.println("Det skjedde en feil ved oppretting av fil.");
        }


        try { //Skrive til fil
            FileWriter skriver = new FileWriter(filNavn);
            System.out.println("Prover aa skrive til filen: " + filNavn);

            skriver.write("# Pasienter (navn, fnr)\n");
            skriver.write(pasientListe.finereStreng());
            
            skriver.write("# Legemidler (navn,type,pris,virkestoff,[styrke])\n");
            for (Legemiddel l : legemiddelListe){
                skriver.write(l.finereStreng() +"\n");
            }
            skriver.write("# Leger (navn,kontrollid / 0 hvis vanlig lege)\n");
            for (Lege l : legeListe){
                skriver.write(l.finereStreng() +"\n");
            }
            skriver.write("# Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])\n");
            for (Resept r : reseptListe){
                skriver.write(r.finereStreng() +"\n");
            }

            System.out.println("Skriving til filen: " + filNavn + ", vellykket.");
            skriver.close();
        } catch (Exception e) { //Hvis skriving til fil feiler
            System.out.println("Skriving til filen: '" + filNavn + "' feilet.");
        }

        System.out.print("Trykk Enter for aa returnere til hovedmeny");
        scanner.nextLine();
    }
    public Prioritetskoe<Lege> hentLegeListe(){
        return this.legeListe;
    }
    public IndeksertListe<Resept> hentReseptListe(){
        return this.reseptListe;
    }
    public IndeksertListe<Legemiddel> hentLegemiddelListe(){
        return this.legemiddelListe;
    }
}

