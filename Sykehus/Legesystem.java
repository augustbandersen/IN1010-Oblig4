package Sykehus;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Lenkeliste.*;

public class Legesystem { 
    private IndeksertListe<Pasient> pasientListe = new IndeksertListe<>();
    private IndeksertListe<Legemiddel> legemiddelListe = new IndeksertListe<>();
    private Prioritetskoe<Lege> legeListe = new Prioritetskoe<>();
    private IndeksertListe<Resept> reseptListe = new IndeksertListe<>();
    
    public void lesFraFil(String filnavn){//Samuel
        Koe<String> linjer = new Koe<>();
        try{
            File fil = new File(filnavn);
            Scanner scanner = new Scanner(fil);
            while(scanner.hasNextLine()){
                linjer.leggTil(scanner.nextLine());
            }
            scanner.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Fil ikke funnet, venligst prøv igjen");  
        }
        String type = "";
        for(String s : linjer){
            if(s.split("#").length > 1){
                type = s.split(" ")[1];
            }
            String[] linje = s.split(",");
            if(type.equals("Pasienter"));
            if(type.equals("Resepter"));
            if(type.equals("Leger"));
            if(type.equals("Resepter"));
            
        }
        
    }

    public void print(){ // August
        //Oversikt over pasienter
        System.out.println("Alle pasienter:");
        for (Pasient p : pasientListe) {
            System.out.println(p);
        }

        //Oversikt over leger
        System.out.println(); // Ny linje
        for (Lege l : legeListe) {
            if (l instanceof Spesialist){
                System.out.println(l + ", Spesialist");
            }
            System.out.println(l + ", vanlig");

        }

        //Oversikt over legemidler
        System.out.println(); // Ny linje
        for (Legemiddel l : legemiddelListe) {
            System.out.println(l);
        }

        //Oversikt over resepter
        System.out.println(); // Ny linje
        for (Resept r : reseptListe) {
            System.out.println(r);
        }

    }

    public void leggTilLege(Lege lege){// Yuki
        

    }

    public void leggTilPasient(Pasient pasient){// Yuki
        
        
    }

    public void leggTilLegemiddel(Legemiddel legemiddel){// Yuki

    }

    public void leggTilResept(Resept resept){// Yuki
        
    }

    public void brukResept(){//Samuel

    }
    public void skrivStatistikk(){// August
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
        IndeksertListe<String[]> narkoLeger = new IndeksertListe<>(); //Sortert i alfabetisk rekkefolge?
        for (Lege l : legeListe){
            int antNarkoResPerLege = 0;
            for (Resept r : l.hentUtskrevneResepter()){
                if (r.hentLegemiddel() instanceof Narkotisk){
                    antNarkoResPerLege++;
                }
            }
            String[] tmp = {l.hentLegeNavn() + " | Antall respter utskrevet: " + antNarkoResPerLege};
            narkoLeger.leggTil(tmp);
        }


        //Pasienter som har minst en gyldig resept paa narkotiske legemidler, og antallet resepter per pasient
        IndeksertListe<String[]> narkoPasienter = new IndeksertListe<>();
        for (Pasient p : pasientListe){
            int antNarkoResPerPasient = 0;
            for (Resept r : p.hentStabel()){
                if (r.hentLegemiddel() instanceof Narkotisk){
                    antNarkoResPerPasient++;
                }
            }
            String[] tmp = {p.hentNavn() + " | Antall respter: " + antNarkoResPerPasient};
            narkoPasienter.leggTil(tmp);
        }


        System.out.println("Antall resepter for vanedannende legemidler: " + antVane);
        System.out.println("Antall resepter for narkotiske legemidler: " + antNarko);

        System.out.println();
        System.out.println("Leger som har skrevet ut resepter paa narkotiske legemidler:");
        System.out.println(narkoLeger);

        System.out.println();
        System.out.println("Pasienter som har gyldig resept paa narkotiske legemidler:");
        System.out.println(narkoPasienter);
    }
}
