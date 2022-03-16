import Lenkeliste.*;
import Sykehus.*;
import java.util.Scanner;
import java.lang.ProcessBuilder;

public class Hovedprogram {
    static Legesystem legesystem = new Legesystem();
    public static void main(String[] args) {
        
        try{
            legesystem.lesFraFil("legedata.txt");
        }catch(Exception e){System.out.println(e);}
        
        while(hovedmeny()){}
    }
    public static void oversikt(){
        System.out.println("Oversikt");
    }
    public static void leggTil(){
        System.out.println("Legg til");
    }
    public static void statistikk(){
        System.out.println("Statistikk");
    }
    public static void skrivTilFil(){
        System.out.println("Skriv til fil");
    }
    public static void brukResept(){
        clearScreen();
        System.out.println("Hvilken pasient vil du se resept for?");
        for(Pasient p : legesystem.hentPasientListe()){
            System.out.println(p);
        }
    }
    public static boolean hovedmeny(){
        Scanner in = new Scanner(System.in);
        String input;
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
            input = in.nextLine();

            try {
                switch(Integer.parseInt(input)){
                    case 1:
                        oversikt();
                        break;
                    case 2:
                        leggTil();
                        break;
                    case 3:
                        statistikk();
                        break;
                    case 4:
                        skrivTilFil();
                        break;
                    case 5:
                        brukResept();
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
        //System.out.print("\033[H\033[2J");  
        //System.out.flush();  
    }  
}
