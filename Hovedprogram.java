import Lenkeliste.*;
import Sykehus.*;
import java.util.Scanner;
import java.io.File;

public class Hovedprogram {
    static Legesystem legesystem = new Legesystem();
    public static void main(String[] args) {
        
        try{
            legesystem.lesFraFil(new File("legedata.txt"));
        }catch(Exception e){System.out.println("exception " + e);}
        
        Scanner scanner = new Scanner(System.in);
        while(true){
            if(!hovedmeny(scanner)) break;
        }
        scanner.close();
    }
    public static void oversikt(){
        System.out.println("Oversikt");
    }
    public static void leggTil(Scanner in){ // Yuki




        System.out.println("Legg til");
    }
    public static void statistikk(){
        System.out.println("Statistikk");
    }
    public static void skrivTilFil(){
        System.out.println("Skriv til fil");
    }
    public static boolean brukResept(Scanner scanner){
        IndeksertListe<Pasient> pasientliste = legesystem.hentPasientListe();
        clearScreen();
        System.out.println("Hvilken pasient vil du se resept for?");
        System.out.println(legesystem.hentPasientListe());
        for(int i = 0; i < pasientliste.stoerrelse(); i++){
            System.out.println(i + ".    " + pasientliste.hent(i));
        }
        System.out.println("Tast inn 'b' for aa returnere til hovedmenyen");
        System.out.print("> ");
        String input = scanner.nextLine();
        try{
            Pasient pasient = pasientliste.hent(Integer.parseInt(input));
            clearScreen();
            IndeksertListe<Resept> resepter = pasient.hentReseptListe();
            System.out.println("Velg resept du vil bruke:\n");
            System.out.println("Reseptene til " + pasient.hentNavn() + ":");
            if(resepter.stoerrelse() < 1){
                System.out.println("\nIngen resepter aa vise");
            }
            else{
                for(int i = 0; i < resepter.stoerrelse(); i++){
                    System.out.println(i + ".\n" + resepter.hent(i));
                }
                System.out.println("");
                input = scanner.nextLine();
                Resept resept = resepter.hent(Integer.parseInt(input));
                resept.bruk();
                if(resept.hentReit() == 0){
                    resepter.fjern(Integer.parseInt(input));
                }
                System.out.println("Resept brukt, reit er naa: " + resept.hentReit());
            }
            System.out.print("\nTast enter for aa returnere til hovedmenyen");
            scanner.nextLine();

        }catch(Exception e){
            if(input.equalsIgnoreCase("b")){
                return false;
            }
            System.out.println("ugyldig input, venligst prøv igjen");
            return true;
        }
        return false;

    }
    public static boolean hovedmeny(Scanner scanner){
        String input = "q";
        Boolean run = true;
        clearScreen();
        System.out.println("Hva oensker du aa gjoere?: ");
        System.out.println("    1. Skrive ut fullstendig oversikt");
        System.out.println("    2. Legge til nytt element");
        System.out.println("    3. Skrive ut statistikk");
        System.out.println("    4. Skrive alle data til fil");
        System.out.println("    5. Bruke resept");
        System.out.println("    Tast inn 'Q' for aa avslutte programmet");
        System.out.print("\nSkirv nummer for oensket gjoeremaal: ");
        input = scanner.nextLine();

        try {
            switch(Integer.parseInt(input)){
                case 1:
                    clearScreen();
                    legesystem.oversikt(scanner);
                    clearScreen();
                    break;
                case 2:
                    leggTil(scanner);
                    break;
                case 3:
                    clearScreen();
                    legesystem.skrivStatistikk(scanner);
                    clearScreen();
                    break;
                case 4:
                    skrivTilFil();
                    break;
                case 5:
                    while(true){
                        if(!brukResept(scanner))break;
                    }
                    break;
                case 6:
                    skrivTilFil(scanner);
                    break;
            }
        } catch (NumberFormatException nfe) {
            if(input.equalsIgnoreCase("q")) run = false;
            System.out.flush();
            System.out.println("Ugyldig input, venligst proev igjen");
        }
        
        return run;
    }
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
    public static void skrivTilFil(Scanner scanner){
        legesystem.skrivTilFil("");
    }
}


