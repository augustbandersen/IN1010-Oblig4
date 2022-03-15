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
        try{
            File fil = new File(filnavn);
            Scanner scanner = new Scanner(filnavn);
            Koe<String> linjer = new Koe<>();
            while(scanner.hasNextLine()){
                linjer.leggTil(scanner.nextLine());
            }
        }
            catch(FileNotFoundException fnf){
                System.out.println("Fil ikke funnet, venligst prøv igjen");
                
            }
            
        }

    public void print(){ // August

    }

    public void leggTilLege(){// Yuki
        

    }

    public void leggTilPasient(){// Yuki
        
        
    }

    public void leggTilLegemiddel(){// Yuki

    }

    public void leggTilResept(){// Yuki
        
    }

    public void brukResept(){//Samuel

    }
    public void skrivStatistikk(){// August

    }
}
