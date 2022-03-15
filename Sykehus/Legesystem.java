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
        for (int i=0; i<pasientListe.length(); i++){ //Trenger en maate aa finne lengden til listen paa
            System.out.println(pasientListe.hent(i));
        }

        //Oversikt over leger
        System.out.println(); // Ny linje


        //Oversikt over legemidler
        System.out.println(); // Ny linje
        for (int i=0; i<legemiddelListe.length(); i++){ //Trenger en maate aa finne lengden til listen paa
            System.out.println(legemiddelListe.hent(i));
        }

        //Oversikt over resepter
        System.out.println(); // Ny linje
        for (int i=0; i<reseptListe.length(); i++){ //Trenger en maate aa finne lengden til listen paa
            System.out.println(reseptListe.hent(i));
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

    }
}
